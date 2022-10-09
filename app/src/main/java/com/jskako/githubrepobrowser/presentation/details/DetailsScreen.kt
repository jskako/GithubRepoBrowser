package com.jskako.githubrepobrowser.presentation.details

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DetailsScreen(
    navController: NavController,
    itemIndex: Int,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    viewModel.getRepositoryDataBy(itemIndex)
    Text("Hello World from Details")
}