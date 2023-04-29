package com.example.tecsupapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class PrincipalActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val actionBar = supportActionBar
        actionBar?.hide()

        val btnNoticias = findViewById<Button>(R.id.btnNewsTecsup)
        val btnCursos = findViewById<Button>(R.id.btnRegistrarCurso)
        val btnDocente = findViewById<Button>(R.id.btnDocente)

        btnNoticias.setOnClickListener {
            startActivity(Intent(this, NoticiasActivity::class.java))
        }

        btnCursos.setOnClickListener {

            val intent = Intent(this, CursosActivity::class.java)
            intent.putExtra("message_key", "Actividad para Cursos")
            startActivity(intent)

        }

        btnDocente.setOnClickListener {
            startActivity(Intent(this, DocentesActivity::class.java))
        }

        val fltBtnShared = findViewById<FloatingActionButton>(R.id.floatingShared)
        fltBtnShared.setOnClickListener {

            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Compartiendo este mensaje")
                type = "text/plain"
            }

            if (sendIntent.resolveActivity(packageManager) != null) {
                startActivity(sendIntent)
            }
        }

        val uri: Uri = Uri.parse("tel:987987987")
        val fltBtnCall = findViewById<FloatingActionButton>(R.id.floatingMenu)
        fltBtnCall.setOnClickListener {
            startActivity(Intent(Intent.ACTION_DIAL, uri))
        }

        val uriLocation: Uri = Uri.parse("geo:0,0?q=Tecsup Trujillo")
        val ftlLocation = findViewById<FloatingActionButton>(R.id.floatingPreguntas)
        ftlLocation.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, uriLocation))
        }

        val uriWeb: Uri = Uri.parse("https://www.tecsup.edu.pe/")
        val ftbWeb = findViewById<FloatingActionButton>(R.id.floatingWeb)
        ftbWeb.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, uriWeb))
        }
    }

    fun openWazeNavigationToB(latitude: Double = -8.111840,
                              longitude : Double = -79.028670)
    {
        val wazeUrl = "https://waze.com/ul?ll=$latitude%2C$longitude&amp;navigate=yes"
        val uri = Uri.parse(wazeUrl)

        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

    fun openGoogleMapsNavigationToB(latitude: Double = -8.111840,
                                    longitude : Double = -79.028670)
    {
        val googleMapsUrl = "google.navigation:q=$latitude,$longitude"
        val uri = Uri.parse(googleMapsUrl)

        val googleMapsPackage = "com.google.android.apps.maps"
        val intent = Intent(Intent.ACTION_VIEW, uri).apply {
            setPackage(googleMapsPackage)
        }

        startActivity(intent)
    }

}