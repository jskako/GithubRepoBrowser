package com.jskako.githubrepobrowser.util

/**
 *  Wrapper class around any type of object
 *  We can use it to distinguish between Success and Error case
 */

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String, data: T?) : Resource<T>(data, message)
}
