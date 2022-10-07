package com.jskako.githubrepobrowser.presentation.main

import com.jskako.githubrepobrowser.domain.util.OrderType
import com.jskako.githubrepobrowser.domain.util.RepositoryOrder

data class MainState(
    val noteOrder: RepositoryOrder = RepositoryOrder.Stars(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)