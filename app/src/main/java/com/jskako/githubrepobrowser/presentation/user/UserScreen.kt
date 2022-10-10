package com.jskako.githubrepobrowser.presentation.user

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.presentation.main.components.createPreviewScreen

@Composable
fun UserScreen(
    context: Context,
    itemIndex: Int,
    viewModel: UserViewModel = hiltViewModel()
) {
    viewModel.getRepositoryDataBy(itemIndex)
    createUserScreen(context, viewModel.repositoryItem.value)
}

@Composable
fun createUserScreen(
    context: Context,
    githubRepository: GithubRepository
) {
    createPreviewScreen(
        context,
        githubRepository.owner.getTitles(),
        githubRepository.owner.getListOfValues(),
        githubRepository.owner.avatar_url ?: ""
    )
}