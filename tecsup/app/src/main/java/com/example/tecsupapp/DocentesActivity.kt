package com.example.tecsupapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DocentesActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_docentes)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Docentes Tecsup"
    }

}