package com.jskako.githubrepobrowser.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class GithubUser(
    val login: String,
    val avatar_url: String,
    val html_url: String
)
