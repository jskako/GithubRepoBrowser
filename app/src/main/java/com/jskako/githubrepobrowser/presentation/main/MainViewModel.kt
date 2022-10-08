package com.jskako.githubrepobrowser.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.use_case.MainUseCases
import com.jskako.githubrepobrowser.domain.util.RepositoryOrder
import com.jskako.githubrepobrowser.data.shared.SharedRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases,
    private var sharedRepositoryData: SharedRepositoryImpl
) : ViewModel() {

    private var orderRepositoriesJob: Job? = null
    val repositoryItems = sharedRepositoryData.getRepositoryItems()

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    fun getAllRepositories(repositoryName: String, language: String = "") =
        viewModelScope.launch {
            refreshRepositoryList(mainUseCases.getRepositories(repositoryName, language))
        }

    private fun refreshRepositoryList(repositories: List<GithubRepository>) {
        sharedRepositoryData.clearRepositoryItems()
        sharedRepositoryData.addRepositoryItems(repositories)
    }

    fun onEvent(event: MainEvent) {
        when (event) {
            is MainEvent.Order -> {
                if (state.value.repositoryOrder::class == event.repositoryOrder::class &&
                    state.value.repositoryOrder.orderType == event.repositoryOrder.orderType
                ) {
                    return
                }
                changeRepositoriesOrder(event.repositoryOrder)
            }
            is MainEvent.ToggleOrderSection -> {
                _state.value = state.value.copy(
                    isOrderSectionVisible = !state.value.isOrderSectionVisible
                )
            }
        }
    }

    private fun changeRepositoriesOrder(repositoryOrder: RepositoryOrder) {
        _state.value = state.value.copy(
            repositoryOrder = repositoryOrder
        )
        orderRepositoriesJob?.cancel()
        /*orderRepositoriesJob = mainUseCases.sortRepositories(_repositoryItems, repositoryOrder)
            .collectLatest { repositoryList ->
                refreshRepositoryList(repositoryList)
            }
            .launchIn(viewModelScope)*/
    }
}