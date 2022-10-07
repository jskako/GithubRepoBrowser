package com.jskako.githubrepobrowser.presentation.main

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.use_case.MainUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases
) : ViewModel() {

    private val _repositoryItems = mutableStateListOf<GithubRepository>()
    val repositoryItems: SnapshotStateList<GithubRepository> = _repositoryItems

    fun getAllRepositories(repositoryName: String, language: String = "") =
        viewModelScope.launch {
            _repositoryItems.clear()
            _repositoryItems.addAll(mainUseCases.getRepositories(repositoryName, language))
        }
}