package com.jskako.githubrepobrowser.domain.model

import com.jskako.githubrepobrowser.data.remote.dto.OwnerDto
import com.jskako.githubrepobrowser.data.remote.dto.getEmptyOwnerDtoObject

data class GithubRepository(
    val repositoryName: String,
    val owner: OwnerDto,
    val description: String,
    val url: String,
    val watchersNumber: Int,
    val forksNumber: Int,
    val issuesNumber: Int,
    val starsNumber: Int,
    val creationDate: String,
    val modificationDate: String,
    val programmingLanguageUsed: String,
    val visibility: Boolean
) {
    fun getTitles(): List<String> = listOf(
        "Repository name",
        "Owner",
        "Description",
        "Url",
        "Watchers",
        "Forks",
        "Issues",
        "Stars",
        "Creation date",
        "Modification date",
        "Programming languages",
        "Visibility"
    )

    fun getListOfValues(): List<String> = listOf(
        repositoryName,
        owner.login ?: "",
        description,
        url,
        watchersNumber.toString(),
        forksNumber.toString(),
        issuesNumber.toString(),
        starsNumber.toString(),
        creationDate,
        modificationDate,
        programmingLanguageUsed,
        visibility.toString()
    )
}

fun getEmptyGithubRepository(): GithubRepository {
    return GithubRepository(
        repositoryName = "",
        owner = getEmptyOwnerDtoObject(),
        description = "",
        url = "",
        watchersNumber = 0,
        forksNumber = 0,
        issuesNumber = 0,
        starsNumber = 0,
        creationDate = "",
        modificationDate = "",
        programmingLanguageUsed = "",
        visibility = false
    )
}