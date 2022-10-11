package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.jskako.githubrepobrowser.R
import com.jskako.githubrepobrowser.presentation.main.core.LANGUAGES_LIST
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun DialogBoxComposable(
    textQueryListener: MutableStateFlow<String>,
    textLanguageListener: MutableStateFlow<String>,
    networkAvailable: Boolean,
    onDismiss: () -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    Dialog(
        onDismissRequest = {
            onDismiss()
        }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth(),
            shadowElevation = 4.dp
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(10.dp)
                        .background(color = primaryColor)
                )

                addSelectionElement(textLanguageListener, "Language", LANGUAGES_LIST)
                addTextInput(textQueryListener, "Search", enabled = networkAvailable)

                Text(
                    modifier = Modifier.padding(start = 12.dp, end = 12.dp),
                    text = "Search is automatically applied while typing",
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                        fontSize = 14.sp
                    )
                )

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 36.dp, start = 36.dp, end = 36.dp, bottom = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = primaryColor),
                    onClick = {
                        onDismiss()
                    }) {
                    Text(
                        text = "Github Login",
                        color = Color.White,
                        style = TextStyle(
                            fontFamily = FontFamily(
                                Font(
                                    R.font.roboto_medium,
                                    FontWeight.Medium
                                )
                            ),
                            fontSize = 16.sp
                        )
                    )
                }

                TextButton(
                    onClick = {
                        onDismiss()
                    }) {
                    Text(
                        text = "Get me out from here",
                        color = primaryColor,
                        style = TextStyle(
                            fontFamily = FontFamily(
                                Font(
                                    R.font.roboto_regular,
                                    FontWeight.Normal
                                )
                            ),
                            fontSize = 14.sp
                        )
                    )
                }
            }
        }
    }
}