package com.emedinaa.infosoft.kotlintemplate

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_java.*

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        app()
    }

    private fun  showMessage(){
        Toast.makeText(this,"Hello Kotlin",Toast.LENGTH_LONG).show()
    }

    private fun app() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //textViewHello
        imageViewJava.setOnClickListener{
            showMessage();
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
