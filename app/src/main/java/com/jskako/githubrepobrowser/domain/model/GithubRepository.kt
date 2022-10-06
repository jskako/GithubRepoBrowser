package com.jskako.githubrepobrowser.domain.model

data class GithubRepository(
    val repositoryName: String,
    val owner: GithubUser,
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