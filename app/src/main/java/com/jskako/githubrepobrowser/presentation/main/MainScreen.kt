package com.jskako.githubrepobrowser.presentation.main


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.rememberCoroutineScope
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.presentation.main.components.CardComposable

@Composable
fun MainScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    viewModel.getAllRepositories("tetris")
    createSearchButton(viewModel, navController)
}

@Composable
fun createSearchButton(viewModel: MainViewModel, navController: NavController) {
    //val state = viewModel.state.value
    val scope = rememberCoroutineScope()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // TODO - Open search settings
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Add note")
            }
        }
    ) {
        createGithubRepoList(viewModel.repositoryItems, navController)
    }
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
