package com.jskako.githubrepobrowser.data.remote.dto

import com.jskako.githubrepobrowser.domain.model.GithubRepository

@kotlinx.serialization.Serializable
data class RepositoriesDto(
    val incomplete_results: Boolean,
    val items: List<ItemsDto>,
    val total_count: Int
) {
    fun getAllItems(): List<GithubRepository> {
        return items.map {
            GithubRepository(
                repositoryName = it.name ?: "",
                owner = it.owner ?: getEmptyOwnerDtoObject(),
                description = it.description ?: "",
                url = it.html_url ?: "",
                watchersNumber = it.watchers_count ?: 0,
                forksNumber = it.forks_count ?: 0,
                issuesNumber = it.open_issues_count ?: 0,
                starsNumber = it.stargazers_count ?: 0,
                creationDate = it.created_at ?: "",
                modificationDate = it.updated_at ?: "",
                programmingLanguageUsed = it.language ?: "",
                visibility = when (it.visibility) {
                    Visibility.PUBLIC.type -> true
                    Visibility.PRIVATE.type -> false
                    else -> false
                }
            )
        }
    }
}

private enum class Visibility(val type: String) {
    PUBLIC("public"),
    PRIVATE("private")
}