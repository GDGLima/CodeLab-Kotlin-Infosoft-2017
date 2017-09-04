package com.emedinaa.infosoft2017.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.emedinaa.infosoft2017.BuildConfig

/**
 * Created by emedinaa on 2/09/17.
 */
open class BaseActivityK : AppCompatActivity() {

    fun log(lambda: () -> String) {
        if (BuildConfig.DEBUG) {
            Log.d("TAG", lambda())
        }
    }

    fun nextActivity(intent: Intent, destroy:Boolean=false){
        startActivity(intent)
        if(destroy) finish()
    }

    fun toast(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}