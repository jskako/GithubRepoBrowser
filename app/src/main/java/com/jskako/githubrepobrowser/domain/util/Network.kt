package com.jskako.githubrepobrowser.domain.util

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.LinkProperties
import android.net.Uri


fun Context.getConnectivityManager() =
    getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

fun isNetworkAvailable(context: Context): Boolean = with(context.getConnectivityManager()) {
    val link = this.getLinkProperties(this.activeNetwork)
    return link is LinkProperties
}

fun openInBrowser(context: Context, link: Uri) {
    if (!isNetworkAvailable(context)) {
        "Network not available".toast(context)
        return
    }
    val defaultBrowser =
        Intent.makeMainSelectorActivity(Intent.ACTION_MAIN, Intent.CATEGORY_APP_BROWSER)
    defaultBrowser.data = link
    if (defaultBrowser.resolveActivity(context.packageManager) != null) {
        context.startActivity(defaultBrowser)
    }
}