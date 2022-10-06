package com.jskako.githubrepobrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.Modifier
import com.jskako.githubrepobrowser.presentation.main.MainViewModel
import com.jskako.githubrepobrowser.ui.theme.GithubRepoBrowserTheme
import dagger.hilt.android.AndroidEntryPoint

// TODO - Check nullable parameters for data class
// TODO - Check if parameter can be send directly by link
// TODO - Remove Log.e()
// Todo - Remove star imports
// Todo - Check for unused imports

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubRepoBrowserTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(
    viewModel: MainViewModel = hiltViewModel()
) {
    viewModel.getAllRepositories("tetris")
}
