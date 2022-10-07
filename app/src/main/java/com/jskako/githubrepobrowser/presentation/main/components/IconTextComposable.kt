package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun IconText(
    image: Int,
    description: String
) {
    Box(modifier = Modifier.wrapContentSize()) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                colorFilter = ColorFilter.tint(Color.Black),
                contentDescription = "",
                modifier = Modifier
                    .padding(start = 14.dp)
                    .size(18.dp),
                contentScale = ContentScale.Inside
            )
            Text(text = description, color = Color.Gray, modifier = Modifier.padding(start = 8.dp))
        }
    }
}