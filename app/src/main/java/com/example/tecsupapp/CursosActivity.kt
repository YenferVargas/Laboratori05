package com.example.tecsupapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CursosActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Cursos Tecsup"

        val intent = intent
        val str = intent.getStringExtra("message_key")

        val txtMessage = findViewById<TextView>(R.id.textPrincipal)
        txtMessage.text = str

    }

}