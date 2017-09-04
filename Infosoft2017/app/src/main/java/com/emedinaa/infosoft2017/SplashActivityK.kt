package com.emedinaa.infosoft2017

import android.content.Intent
import android.os.Bundle
import com.emedinaa.infosoft2017.ui.BaseActivityK
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivityK : BaseActivityK() {

    private val TIME:Long=2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        app()
    }

    private fun goToMain(){
        nextActivity(Intent(this, MainActivityK::class.java),true)
    }

    private fun app() {
        log({"Start SplashActivityK"})
        Timer().schedule(timerTask {
            goToMain() },TIME)
    }
}
