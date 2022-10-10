package com.jskako.githubrepobrowser.presentation.main

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.use_case.MainUseCases
import com.jskako.githubrepobrowser.domain.util.RepositoryOrder
import com.jskako.githubrepobrowser.data.shared.SharedRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases,
    private var sharedRepositoryData: SharedRepositoryImpl
) : ViewModel() {

    private var orderRepositoriesJob: Job? = null
    val repositoryItems = sharedRepositoryData.getRepositoryItems()
    private val _state = mutableStateOf(OrderState())
    val orderState: State<OrderState> = _state
    
    val textQueryListener = MutableStateFlow("")
    val textLanguageListener = MutableStateFlow("")


    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val fetchQuerySuccessfully = textQueryListener.debounce(2000)
        .distinctUntilChanged()
        .flatMapLatest {
            if(it.isNotEmpty()) {
                getAllRepositories(it, textLanguageListener.value)
            } else {
                flowOf(FetchSuccessful.IGNORE)
            }
        }

    private suspend fun getAllRepositories(
        repositoryName: String,
        language: String = ""
    ): Flow<FetchSuccessful> {
        return flow {
            emit(refreshRepositoryList(mainUseCases.getRepositories(repositoryName, language)))
        }.flowOn(Dispatchers.IO)
    }

    private fun refreshRepositoryList(
        repositories: List<GithubRepository>,
        showToast: Boolean = true
    ): FetchSuccessful {
        return if (repositories.isNotEmpty()) {
            sharedRepositoryData.clearRepositoryItems()
            sharedRepositoryData.addRepositoryItems(repositories)
            if (showToast) FetchSuccessful.SUCCESSFUL else FetchSuccessful.IGNORE
        } else {
            if (showToast) FetchSuccessful.NOT_SUCCESSFUL else FetchSuccessful.IGNORE
        }
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.Order -> {
                if (orderState.value.repositoryOrder::class == event.repositoryOrder::class &&
                    orderState.value.repositoryOrder.orderType == event.repositoryOrder.orderType
                ) {
                    return
                }
                changeRepositoriesOrder(event.repositoryOrder)
            }
            is MainEvent.ToggleOrderSection -> {
                _state.value = orderState.value.copy(
                    isOrderSectionVisible = !orderState.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun changeRepositoriesOrder(repositoryOrder: RepositoryOrder) {
        _state.value = orderState.value.copy(
            repositoryOrder = repositoryOrder
        )
        orderRepositoriesJob?.cancel()
        orderRepositoriesJob =
            mainUseCases.sortRepositories(flowOf(repositoryItems), repositoryOrder)
                .onEach { repositoryList ->
                    refreshRepositoryList(repositoryList, false)
                }
                .launchIn(viewModelScope)
    }
}

enum class FetchSuccessful {
    SUCCESSFUL, NOT_SUCCESSFUL, IGNORE
}