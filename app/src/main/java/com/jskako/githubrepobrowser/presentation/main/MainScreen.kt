package com.jskako.githubrepobrowser.presentation.main


import android.content.Context
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.util.openInBrowser
import com.jskako.githubrepobrowser.presentation.main.components.CardComposable
import com.jskako.githubrepobrowser.presentation.main.components.DialogBoxComposable
import com.jskako.githubrepobrowser.presentation.main.components.OrderSection
import com.jskako.githubrepobrowser.presentation.util.Screen

@Composable
fun MainScreen(
    context: Context,
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {

    viewModel.getAllRepositories("tetris")
    createMainScreen(context, viewModel, navController)
}

@Composable
fun createMainScreen(context: Context, viewModel: MainViewModel, navController: NavController) {
    val state = viewModel.state.value
    var openDialog by remember {
        mutableStateOf(false)
    }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    openDialog = true
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Github Repository Filter"
                )
            }
            if (openDialog) {
                DialogBoxComposable {
                    openDialog = false
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Github Repository Search",
                    style = MaterialTheme.typography.bodyMedium
                )
                IconButton(
                    onClick = {
                        viewModel.onEvent(MainEvent.ToggleOrderSection)
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Sort,
                        contentDescription = "Sort"
                    )
                }
            }
            AnimatedVisibility(
                visible = state.isOrderSectionVisible,
                enter = fadeIn() + slideInVertically(),
                exit = fadeOut() + slideOutVertically()
            ) {
                OrderSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    repositoryOrder = state.repositoryOrder,
                    onOrderChange = {
                        viewModel.onEvent(MainEvent.Order(it))
                    }
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            createGithubRepoList(context, viewModel.repositoryItems, navController)
        }
    }
}

@Composable
fun createGithubRepoList(
    context: Context,
    items: List<GithubRepository>,
    navController: NavController
) {
    LazyColumn {
        itemsIndexed(items) { index, item ->
            CardComposable(
                item,
                navController,
                listOf("View", "Open in browser"),
                listOf(
                    {
                        navController.navigate(
                            Screen.UserScreen.route +
                                    "?itemIndex=${index}"
                        )
                    }, // This will send data to user screen
                    { openInBrowser(context, Uri.parse(item.owner.html_url)) }
                )
            )
        }
    }
}
