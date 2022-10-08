package com.jskako.githubrepobrowser.data.shared

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.jskako.githubrepobrowser.domain.model.GithubRepository

interface SharedRepository {

    fun getRepositoryItems(): SnapshotStateList<GithubRepository>
    fun addRepositoryItems(repositories: List<GithubRepository>)
    fun getRepositoryDataBy(index: Int): GithubRepository
    fun clearRepositoryItems()
}