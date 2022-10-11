package com.jskako.githubrepobrowser.domain.network

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.ui.platform.LocalContext

sealed class ConnectionState {
    object Available : ConnectionState()
    object Unavailable : ConnectionState()
}

fun getCurrentConnectivityState(
    connectivityManager: ConnectivityManager
): ConnectionState {
    val network = connectivityManager.activeNetwork
    val connected = connectivityManager.getNetworkCapabilities(network)
        ?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        ?: false

    return if (connected) ConnectionState.Available else ConnectionState.Unavailable
}

fun networkCallback(callback: (ConnectionState) -> Unit): ConnectivityManager.NetworkCallback {
    return object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            callback(ConnectionState.Available)
        }

        override fun onLost(network: Network) {
            callback(ConnectionState.Unavailable)
        }
    }
}

@Composable
fun ConnectivityState(): State<ConnectionState> {
    val context = LocalContext.current
    return produceState(initialValue = context.currentConnectivityState) {
        context.observeConnectivityAsFlow().collect { value = it }
    }
}