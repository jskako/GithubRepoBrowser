package com.jskako.githubrepobrowser.presentation.details

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.presentation.main.components.createPreviewScreen

@Composable
fun DetailsScreen(
    context: Context,
    itemIndex: Int,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    viewModel.getRepositoryDataBy(itemIndex)
    createDetailsScreen(context, viewModel.repositoryItem.value)
}

@Composable
fun createDetailsScreen(
    context: Context,
    githubRepository: GithubRepository
) {
    createPreviewScreen(
        context,
        githubRepository.getTitles() + "Owner Url",
        githubRepository.getListOfValues() + (githubRepository.owner.html_url ?: ""),
        githubRepository.owner.avatar_url ?: ""
    )
}