package com.jskako.githubrepobrowser.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.use_case.MainUseCases
import com.jskako.githubrepobrowser.domain.util.RepositoryOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases
) : ViewModel() {

    private var orderRepositoriesJob: Job? = null

    private val _repositoryItems = mutableStateListOf<GithubRepository>()
    val repositoryItems: SnapshotStateList<GithubRepository> = _repositoryItems

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    fun getAllRepositories(repositoryName: String, language: String = "") =
        viewModelScope.launch {
            refreshRepositoryList(mainUseCases.getRepositories(repositoryName, language))
        }

    private fun refreshRepositoryList(repositories: List<GithubRepository>) {
        _repositoryItems.clear()
        _repositoryItems.addAll(repositories)
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