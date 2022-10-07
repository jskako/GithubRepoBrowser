package com.jskako.githubrepobrowser.presentation.main


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.presentation.main.components.CardComposable

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    viewModel.getAllRepositories("tetris")
    createGithubRepoList(viewModel.repositoryItems, navController)
}

@Composable
fun createGithubRepoList(items: List<GithubRepository>, navController: NavController) {

    Surface(color = MaterialTheme.colorScheme.background) {
        LazyColumn {
            items(items) { item ->
                CardComposable(item, navController)
            }
        }
    }
}
