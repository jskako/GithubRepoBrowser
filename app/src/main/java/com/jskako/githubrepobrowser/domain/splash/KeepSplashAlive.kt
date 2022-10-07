package com.jskako.githubrepobrowser.domain.splash

import androidx.core.splashscreen.SplashScreen
import com.jskako.githubrepobrowser.domain.util.delay

class KeepSplashAlive(private val splashScreen: SplashScreen) {

    private var splashScreenAlive = true

    fun init(splashScreenDuration: Long = 2000L) {
        // Keep SplashScreen alive until keep equals true
        splashScreen.setKeepOnScreenCondition { splashScreenAlive }

        delay(splashScreenDuration) {
            splashScreenAlive = false
        }
    }

}