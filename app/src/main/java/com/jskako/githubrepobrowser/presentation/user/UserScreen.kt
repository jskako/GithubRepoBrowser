package com.jskako.githubrepobrowser.presentation.user

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun UserScreen(
    navController: NavController,
    itemIndex: Int,
    viewModel: UserViewModel = hiltViewModel()
) {
    viewModel.getRepositoryDataBy(itemIndex)
    Text("Hello World from Details")
}