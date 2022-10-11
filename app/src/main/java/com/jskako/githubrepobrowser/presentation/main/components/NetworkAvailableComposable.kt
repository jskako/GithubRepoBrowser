package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jskako.githubrepobrowser.R

@Composable
fun createNetworkAvailableBox(networkAvailable: Boolean) {
    AnimatedVisibility(
        visible = !networkAvailable,
        enter = fadeIn() + slideInVertically(),
        exit = fadeOut() + slideOutVertically()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
                .background(color = Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Network not available",
                style = TextStyle(
                    fontFamily = FontFamily(
                        Font(
                            R.font.roboto_regular,
                            FontWeight.Normal
                        )
                    ),
                )
            )
        }
    }
}