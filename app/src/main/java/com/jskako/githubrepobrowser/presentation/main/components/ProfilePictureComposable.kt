package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import androidx.compose.ui.unit.dp
import com.jskako.githubrepobrowser.R
import com.jskako.githubrepobrowser.domain.model.GithubRepository

@Composable
fun ProfilePictureComposable (
    item: GithubRepository,
    menuItems: List<String>,
    onClickCallbacks: List<() -> Unit>,
) {
    var showMenu by remember { mutableStateOf(false) }

    Card(
        shape = CircleShape,
        border = BorderStroke(2.dp, color = Helper.getGreenColor()),
        modifier = Modifier
            .size(48.dp)
            .padding(2.dp)
            .clickable {
                showMenu = true
            },
    ) {
        Image(
            painter = rememberAsyncImagePainter(item.owner.avatar_url),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(48.dp),
            contentDescription = stringResource(R.string.picture_holder_title)
        )
    }
    PopupMenu(
        menuItems = menuItems,
        onClickCallbacks = onClickCallbacks,
        showMenu = showMenu,
        onDismiss = ({ showMenu = false })
    )
}