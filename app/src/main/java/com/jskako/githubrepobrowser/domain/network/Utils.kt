package com.jskako.githubrepobrowser.domain.network

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.jskako.githubrepobrowser.domain.util.toast

fun openInBrowser(context: Context, link: Uri) {
    when(context.currentConnectivityState) {
        ConnectionState.Available -> {
            val defaultBrowser =
                Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
            defaultBrowser.data = link
            context.startActivity(defaultBrowser)
        }
        ConnectionState.Unavailable -> {
            "Network not available".toast(context)
        }
    }
}