package com.jskako.githubrepobrowser.domain.model

import com.jskako.githubrepobrowser.data.remote.dto.OwnerDto

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
)