package com.emedinaa.infosoft2017

import android.content.Intent
import android.os.Bundle
import com.emedinaa.infosoft2017.ui.BaseActivity
import java.util.*
import kotlin.concurrent.timerTask

class SplashActivity : BaseActivity() {

    private val TIME:Long=2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        app();
    }

    private fun goToMain(){
        nextActivity(Intent(this,MainActivity::class.java),true)
    }

    private fun app() {
        log({"Start SplashActivity"})
        Timer().schedule(timerTask {
            goToMain() },TIME)
    }
}
