package com.jskako.githubrepobrowser.domain.use_case

import com.jskako.githubrepobrowser.data.remote.GithubService

class GetRepositoriesUseCase(
    private val githubService: GithubService
) {
    suspend operator fun invoke(repositoryName: String, language: String) =
        githubService.getAllRepositories(repositoryName, language)
}