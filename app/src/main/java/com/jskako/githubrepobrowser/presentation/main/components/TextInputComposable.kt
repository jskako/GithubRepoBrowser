package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.foundation.focusable
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.jskako.githubrepobrowser.R
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun addTextInput(
    textQueryListener: MutableStateFlow<String>,
    label: String = "",
    defaultText: String = "",
    enabled: Boolean = true
): String {

    val text by textQueryListener.collectAsState(defaultText)
    TextField(
        modifier = Modifier
            .focusable(),
        value = text,
        enabled = enabled,
        onValueChange = {
            textQueryListener.value = it
        },
        label = { Text(label) },
        textStyle = TextStyle(
            fontFamily = FontFamily(Font(R.font.roboto_medium, FontWeight.Medium)),
            fontSize = 20.sp
        )
    )
    return text
}