package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jskako.githubrepobrowser.domain.util.OrderType
import com.jskako.githubrepobrowser.domain.util.RepositoryOrder

@Composable
fun OrderSection(
    modifier: Modifier = Modifier,
    repositoryOrder: RepositoryOrder = RepositoryOrder.Stars(OrderType.Descending),
    onOrderChange: (RepositoryOrder) -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Stars",
                selected = repositoryOrder is RepositoryOrder.Stars,
                onSelect = { onOrderChange(RepositoryOrder.Stars(repositoryOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Forks",
                selected = repositoryOrder is RepositoryOrder.Forks,
                onSelect = { onOrderChange(RepositoryOrder.Forks(repositoryOrder.orderType)) }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Last Update",
                selected = repositoryOrder is RepositoryOrder.Updated,
                onSelect = { onOrderChange(RepositoryOrder.Updated(repositoryOrder.orderType)) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            DefaultRadioButton(
                text = "Ascending",
                selected = repositoryOrder.orderType is OrderType.Ascending,
                onSelect = {
                    onOrderChange(repositoryOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = repositoryOrder.orderType is OrderType.Descending,
                onSelect = {
                    onOrderChange(repositoryOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}