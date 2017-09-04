package com.emedinaa.infosoft2017.ui.fragmentskt

import android.support.v4.app.Fragment
import android.util.Log
import com.emedinaa.infosoft2017.BuildConfig
import retrofit2.Call

/**
 * Created by emedinaa on 3/09/17.
 */
open class BaseFragmentK<T>:Fragment() {

    protected var currentCall:Call<T>?=null;

    fun log(lambda: () -> String) {
        if (BuildConfig.DEBUG) {
            Log.d("TAG", lambda())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        currentCall!!.cancel()
    }
}