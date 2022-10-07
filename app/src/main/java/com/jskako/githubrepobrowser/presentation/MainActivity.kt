package com.jskako.githubrepobrowser.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jskako.githubrepobrowser.R
import com.jskako.githubrepobrowser.domain.splash.KeepSplashAlive
import com.jskako.githubrepobrowser.presentation.details.DetailsScreen
import com.jskako.githubrepobrowser.presentation.main.MainScreen
import com.jskako.githubrepobrowser.presentation.user.UserScreen
import com.jskako.githubrepobrowser.presentation.util.Screen
import com.jskako.githubrepobrowser.ui.theme.GithubRepoBrowserTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        changeBarsColor()
        super.onCreate(savedInstanceState)
        setSplashScreen()
        setContent {
            GithubRepoBrowserTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.MainScreen.route
                    ) {
                        composable(route = Screen.MainScreen.route) {
                            MainScreen(navController = navController)
                        }
                        composable(route = Screen.DetailsScreen.route) {
                            DetailsScreen(navController = navController)
                        }
                        composable(route = Screen.UserScreen.route) {
                            UserScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }

    private fun setSplashScreen() {
        KeepSplashAlive(installSplashScreen()).init()
    }

    private fun changeBarsColor() {
        window.statusBarColor = getColor(R.color.purple_40)
        window.navigationBarColor = getColor(R.color.purple_40)
    }
}
