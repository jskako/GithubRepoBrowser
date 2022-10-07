package com.jskako.githubrepobrowser.domain.util

sealed class RepositoryOrder(val orderType: OrderType) {
    class Stars(orderType: OrderType) : RepositoryOrder(orderType)
    class Forks(orderType: OrderType) : RepositoryOrder(orderType)
    class Updated(orderType: OrderType) : RepositoryOrder(orderType)

    fun copy(orderType: OrderType): RepositoryOrder {
        return when (this) {
            is Stars -> Stars(orderType)
            is Forks -> Forks(orderType)
            is Updated -> Updated(orderType)
        }
    }
}