package com.jskako.githubrepobrowser.presentation.main.components

import android.content.Context
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jskako.githubrepobrowser.R
import com.jskako.githubrepobrowser.domain.network.openInBrowser

@Composable
fun ItemCardComposable(
    context: Context,
    title: String,
    description: String,
    index: Int
) {
    val color = if (index % 2 == 0) Helper.getLightGrayColor() else Helper.getWhiteColor()
    val clickable = description.startsWith("http://") || description.startsWith("https://")
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(color = color)
            .padding(10.dp)
            .clickable {
                if (clickable) openInBrowser(context, Uri.parse(description))
            },
    ) {
        Column(
            modifier = Modifier
                .height(intrinsicSize = IntrinsicSize.Max)
                .padding(10.dp)
        ) {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_bold, FontWeight.Bold)),
                    fontSize = 20.sp
                )
            )

            Text(
                text = description,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.roboto_regular, FontWeight.Normal)),
                    fontSize = 14.sp
                )
            )
        }
    }
}