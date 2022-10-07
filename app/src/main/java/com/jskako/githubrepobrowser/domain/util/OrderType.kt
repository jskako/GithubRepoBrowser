package com.jskako.githubrepobrowser.domain.util

sealed class OrderType {
    object Ascending: OrderType()
    object Descending: OrderType()
}