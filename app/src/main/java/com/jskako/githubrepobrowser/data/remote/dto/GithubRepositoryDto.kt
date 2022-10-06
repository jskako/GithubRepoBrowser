package com.jskako.githubrepobrowser.data.remote.dto

import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.model.GithubUser
import kotlinx.serialization.Serializable

@Serializable
data class GithubRepositoryDto(
    val name: String,
    val owner: GithubUser,
    val description: String,
    val url: String,
    val watchers_count: Int,
    val forks_count: Int,
    val open_issues_count: Int,
    val stargazers_count: Int,
    val created_at: String,
    val updated_at: String,
    val language: String,
    val visibility: String
) {
    fun toGithubRepo(): GithubRepository {
        return GithubRepository(
            repositoryName = name,
            owner = owner,
            description = description,
            url = url,
            watchersNumber = watchers_count,
            forksNumber = forks_count,
            issuesNumber = open_issues_count,
            starsNumber = stargazers_count,
            creationDate = created_at,
            modificationDate = updated_at,
            programmingLanguageUsed = language,
            visibility = when (visibility) {
                "public" -> true
                else -> false
            }
        )
    }
}