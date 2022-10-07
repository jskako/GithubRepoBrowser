package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.jskako.githubrepobrowser.domain.model.GithubRepository

@Composable
fun ProfileContentComposable(item: GithubRepository) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 8.dp),
        verticalArrangement = Arrangement.aligned(Alignment.CenterVertically)
    ) {
        Text(item.repositoryName, fontWeight = FontWeight.Bold)
        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "${item.owner.login}\n${item.description}",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}