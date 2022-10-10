package com.jskako.githubrepobrowser.domain.use_case

import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.util.OrderType
import com.jskako.githubrepobrowser.domain.util.RepositoryOrder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SortRepositoriesUseCase {

operator fun invoke(
    repositories: Flow<List<GithubRepository>>,
    repositoryOrder: RepositoryOrder = RepositoryOrder.Stars(OrderType.Descending)
): Flow<List<GithubRepository>> {
    return repositories.map { notes ->
        when (repositoryOrder.orderType) {
            is OrderType.Ascending -> {
                when (repositoryOrder) {
                    is RepositoryOrder.Stars -> notes.sortedBy { it.starsNumber }
                    is RepositoryOrder.Forks -> notes.sortedBy { it.forksNumber }
                    is RepositoryOrder.Updated -> notes.sortedBy { it.modificationDate.lowercase() }
                }
            }
            is OrderType.Descending -> {
                when (repositoryOrder) {
                    is RepositoryOrder.Stars -> notes.sortedByDescending { it.starsNumber }
                    is RepositoryOrder.Forks -> notes.sortedByDescending { it.forksNumber }
                    is RepositoryOrder.Updated -> notes.sortedByDescending { it.modificationDate.lowercase() }
                }
            }
        }
    }
}
}