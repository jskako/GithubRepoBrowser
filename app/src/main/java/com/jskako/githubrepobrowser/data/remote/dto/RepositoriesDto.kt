package com.jskako.githubrepobrowser.data.remote.dto

import com.jskako.githubrepobrowser.domain.model.GithubRepository

@kotlinx.serialization.Serializable
data class RepositoriesDto(
    val incomplete_results: Boolean,
    val items: List<ItemsDto>,
    val total_count: Int
) {
    fun toList(): List<GithubRepository> {
        return items.map {
            GithubRepository(
                repositoryName = it.name,
                owner = it.owner,
                description = it.description ?: "",
                url = it.url,
                watchersNumber = it.watchers_count,
                forksNumber = it.forks_count,
                issuesNumber = it.open_issues_count,
                starsNumber = it.stargazers_count,
                creationDate = it.created_at,
                modificationDate = it.updated_at,
                programmingLanguageUsed = it.language,
                visibility = when (it.visibility) {
                    "public" -> true
                    else -> false
                }
            )
        }
    }
}