package com.jskako.githubrepobrowser.domain.use_case

data class MainUseCases(
    val getRepositories: GetRepositoriesUseCase,
    val sortRepositories: SortRepositoriesUseCase,
)
