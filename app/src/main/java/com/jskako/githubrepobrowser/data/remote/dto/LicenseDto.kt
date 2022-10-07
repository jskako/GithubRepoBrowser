package com.jskako.githubrepobrowser.data.remote.dto

@kotlinx.serialization.Serializable
data class LicenseDto(
    val key: String?,
    val name: String?,
    val spdx_id: String?,
    val url: String?,
    val node_id: String?
)