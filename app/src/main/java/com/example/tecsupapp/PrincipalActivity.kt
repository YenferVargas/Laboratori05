package com.example.tecsupapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView


class PrincipalActivity: AppCompatActivity(), PopupMenu.OnMenuItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val actionBar = supportActionBar
        actionBar?.hide()
         
        val btnNoticias = findViewById<Button>(R.id.btnNewsTecsup)
        val btnCursos = findViewById<Button>(R.id.btnRegistrarCurso)
        val btnDocente = findViewById<Button>(R.id.btnDocente)
        val btnNotas = findViewById<Button>(R.id.btnNotas)

        btnNotas.setOnClickListener(){
            startActivity(Intent(this,NotaActivity::class.java))
        }

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
            //startActivity(Intent(Intent.ACTION_VIEW, uriLocation))
        }

        val uriWeb: Uri = Uri.parse("https://www.tecsup.edu.pe/")
        val ftbWeb = findViewById<FloatingActionButton>(R.id.floatingWeb)
        ftbWeb.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, uriWeb))
        }
    }
    fun showPopPup(v: View) {
        val poppup = PopupMenu(this, v)
        val inflater: MenuInflater = poppup.menuInflater
        inflater.inflate(R.menu.menu_emergente, poppup.menu)
        poppup.setOnMenuItemClickListener(this)
        poppup.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            R.id.itemMenuMensaje -> {
                Toast.makeText(this, "Mensaje", Toast.LENGTH_LONG).show()
                true
            }
            R.id.itemMenuConversar -> {
                Toast.makeText(this, "Conversar", Toast.LENGTH_LONG).show()
                true
            }
            R.id.itemMenuPreguntas -> {
                Toast.makeText(this, "Preguntas", Toast.LENGTH_LONG).show()
                true
            }
            else -> false
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
     //val nav_view = findViewById<NavigationView>(R.id.nav_view)
     //val drawer_layout= findViewById<DrawerLayout>(R.id.nav_view)
    //val nav_view = findViewById(R.id.nav_view)
     //val drawer_layout=findViewById(R.id.nav_view)

    private fun configurationNavigationDrawer() {
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        val drawer_layout= findViewById<DrawerLayout>(R.id.drawer_layout)
        nav_view.setNavigationItemSelectedListener { menuItem ->
            drawer_layout.closeDrawer(GravityCompat.START)
            when(menuItem.itemId) {
                R.id.nav_calculator -> {
                    menuItem.isChecked = true
                    startActivity(Intent(this,CalculadoraActivity::class.java))
                    Toast.makeText(this,"Profile",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_galery -> {
                    Toast.makeText(this, "Gallery",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_galery -> {
                    Toast.makeText(this, "Slideshow",Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

    private fun configurationNavigationDrawer2() {
        val nav_view = findViewById<NavigationView>(R.id.nav_view2)
        val drawer_layout= findViewById<DrawerLayout>(R.id.drawer_layout2)
        nav_view.setNavigationItemSelectedListener { menuItem ->
            drawer_layout.closeDrawer(GravityCompat.START)
            when(menuItem.itemId) {
                R.id.nav_nocias -> {
                    menuItem.isChecked = true
                    startActivity(Intent(this,CalculadoraActivity::class.java))
                    Toast.makeText(this,"Noticias",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_curso -> {
                    Toast.makeText(this, "Cursosos",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_profesor -> {
                    Toast.makeText(this, "Profesor",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_estudiante -> {
                    Toast.makeText(this, "Estudiante",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_notas -> {
                    Toast.makeText(this, "Notas",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_contactos -> {
                    Toast.makeText(this, "Comunicacion",Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.nav_libro -> {
                    Toast.makeText(this, "Libro",Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    false
                }
            }
        }
    }

}