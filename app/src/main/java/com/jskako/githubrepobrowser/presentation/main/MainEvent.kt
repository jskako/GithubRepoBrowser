package com.jskako.githubrepobrowser.presentation.main

import com.jskako.githubrepobrowser.domain.util.RepositoryOrder

sealed class MainEvent {
    data class Order(val repositoryOrder: RepositoryOrder): MainEvent()
    object ToggleOrderSection: MainEvent()
}
