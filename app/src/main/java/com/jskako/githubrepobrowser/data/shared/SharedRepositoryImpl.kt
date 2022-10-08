package com.jskako.githubrepobrowser.data.shared

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import com.jskako.githubrepobrowser.domain.model.GithubRepository

object SharedRepositoryImpl : SharedRepository {
    private val repositoryItems = mutableStateListOf<GithubRepository>()

    override fun getRepositoryItems(): SnapshotStateList<GithubRepository> = repositoryItems
    override fun addRepositoryItems(repositories: List<GithubRepository>) {
        repositoryItems.addAll(repositories)
    }
    override fun getRepositoryDataBy(index: Int): GithubRepository = repositoryItems[index]
    override fun clearRepositoryItems() = repositoryItems.clear()
}