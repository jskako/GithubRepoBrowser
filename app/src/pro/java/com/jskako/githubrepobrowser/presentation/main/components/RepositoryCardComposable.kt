package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.jskako.githubrepobrowser.R
import com.jskako.githubrepobrowser.domain.model.GithubRepository

@Composable
fun RepositoryCardComposable(
    item: GithubRepository,
    pictureMenuItems: List<String>,
    onPictureClickCallbacks: List<() -> Unit>,
    onCardClickCallbacks: List<() -> Unit>,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))
            .background(color = Helper.getWhiteColor())
            .padding(10.dp)
            .clickable {
                onCardClickCallbacks.forEach {
                    it()
                }
            },
    ) {
        Row(
            modifier = Modifier
                .height(intrinsicSize = IntrinsicSize.Max)
                .padding(10.dp)
        ) {
            ProfilePictureComposable(item, pictureMenuItems, onPictureClickCallbacks)
            ProfileContentComposable(item)
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(intrinsicSize = IntrinsicSize.Max)
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            IconText(image = R.drawable.ic_fork, description = item.forksNumber.toString())
            IconText(image = R.drawable.ic_watch, description = item.watchersNumber.toString())
            IconText(image = R.drawable.ic_star, description = item.starsNumber.toString())
        }
    }
}