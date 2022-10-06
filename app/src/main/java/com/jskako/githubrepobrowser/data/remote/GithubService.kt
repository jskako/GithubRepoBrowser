package com.jskako.githubrepobrowser.data.remote

import com.jskako.githubrepobrowser.domain.model.GithubRepository

interface GithubService {

    suspend fun getAllRepositories(repositoryName: String, language: String = ""): List<GithubRepository>

    companion object {
        const val BASE_URL = "https://api.github.com/search/repositories"
    }

    sealed class Endpoints(val url: String) {
        object GetAllRepositories: Endpoints("$BASE_URL?q=")
    }
}