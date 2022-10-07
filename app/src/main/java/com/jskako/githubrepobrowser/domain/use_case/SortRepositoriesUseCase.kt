package com.jskako.githubrepobrowser.domain.use_case

import com.jskako.githubrepobrowser.domain.model.GithubRepository
import com.jskako.githubrepobrowser.domain.util.OrderType
import com.jskako.githubrepobrowser.domain.util.RepositoryOrder
import kotlinx.coroutines.flow.Flow

class SortRepositoriesUseCase /*{

operator fun invoke(
    repositories: List<GithubRepository>,
    repositoryOrder: RepositoryOrder = RepositoryOrder.Stars(OrderType.Descending)
): Flow<List<GithubRepository>> {
    return repositories.map { notes ->
        when (repositoryOrder.orderType) {
            is OrderType.Ascending -> {
                when (repositoryOrder) {
                    is RepositoryOrder.Stars -> notes.sortedBy { it.title.lowercase() }
                    is RepositoryOrder.Forks -> notes.sortedBy { it.timeStamp }
                    is RepositoryOrder.Updated -> notes.sortedBy { it.color }
                }
            }
            is OrderType.Descending -> {
                when (repositoryOrder) {
                    is RepositoryOrder.Stars -> notes.sortedByDescending { it.title.lowercase() }
                    is RepositoryOrder.Forks -> notes.sortedByDescending { it.timeStamp }
                    is RepositoryOrder.Updated -> notes.sortedByDescending { it.color }
                }
            }
        }
    }
}
}*/