package com.jskako.githubrepobrowser.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jskako.githubrepobrowser.domain.use_case.MainUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainUseCases: MainUseCases
) : ViewModel() {

    fun getAllRepositories(repositoryName: String, language: String = "") =
        viewModelScope.launch {
            mainUseCases.getRepositories(repositoryName, language)
        }
}