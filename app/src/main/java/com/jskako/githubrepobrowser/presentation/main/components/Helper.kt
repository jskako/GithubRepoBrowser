package com.jskako.githubrepobrowser.presentation.main.components

import androidx.compose.ui.graphics.Color

object Helper {

    private fun getColor(colorString: String) =
        Color(android.graphics.Color.parseColor("#$colorString"))

    fun getGreenColor() = getColor("9963890a")
    fun getWhiteColor() = getColor("FFFFFFFF")
    fun getRedColor() = getColor("99ac162c")

}