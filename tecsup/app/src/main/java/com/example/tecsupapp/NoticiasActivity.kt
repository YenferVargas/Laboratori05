package com.example.tecsupapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class NoticiasActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noticias)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        title = "Noticias Tecsup"

        val webViewNews = findViewById<WebView>(R.id.webViewNews)
        webViewNews.webViewClient = WebViewClient()
        webViewNews.loadUrl("https://www.tecsup.edu.pe/")
        webViewNews.settings.javaScriptEnabled = true
    }

}