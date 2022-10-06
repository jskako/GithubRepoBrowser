package com.jskako.githubrepobrowser.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jskako.githubrepobrowser.data.remote.GithubService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubService: GithubService
): ViewModel() {

    fun getAllRepositories(repositoryName: String, language: String = "") {
        viewModelScope.launch {
            val test = githubService.getAllRepositories(repositoryName, language)
            Log.e("My test:", "Test: $test")
        }
    }
}