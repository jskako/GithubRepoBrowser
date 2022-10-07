package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import com.jskako.githubrepobrowser.R

@Composable
fun ProfilePictureComposable(imageUrl: String?) {
    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = Helper.getGreenColor()),
        modifier = Modifier
            .size(48.dp)
            .padding(2.dp)
            .clickable {
                // TODO - Add context/dropdown menu
            },
    ) {
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(48.dp),
            contentDescription = stringResource(R.string.picture_holder_title)
        )
    }
}