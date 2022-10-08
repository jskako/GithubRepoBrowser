package com.jskako.githubrepobrowser.presentation.core

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jskako.githubrepobrowser.data.shared.SharedRepositoryImpl
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.model.getEmptyGithubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class SharedViewModel @Inject constructor(
    private var sharedRepositoryData: SharedRepositoryImpl
) : ViewModel() {
    private val _repositoryItem = mutableStateOf(getEmptyGithubRepository())
    val repositoryItem: State<GithubRepository> = _repositoryItem

    fun getRepositoryDataBy(index: Int) {
        _repositoryItem.value = sharedRepositoryData.getRepositoryDataBy(index)
    }
}