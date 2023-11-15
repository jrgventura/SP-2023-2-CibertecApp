package com.cibertec.cibertecapp.noticias

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.MenuActivity
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.mapas.MapasActivity
import com.google.android.material.navigation.NavigationView

class WelcomeActivity: AppCompatActivity(), NoticiasAdapter.ItemClickNoticia {

    private lateinit var viewModel: NoticiasViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        viewModel = ViewModelProvider(this)[NoticiasViewModel::class.java]
        viewModel.getNoticiasFirebase()


        val recyclerNews = findViewById<RecyclerView>(R.id.recyclerNews)
        val adapter = NoticiasAdapter(this)
        recyclerNews.adapter = adapter
        recyclerNews.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

        viewModel.listNoticiasMutable.observe(this) { listNoticias ->

            if (listNoticias.isNotEmpty()) {
                adapter.setNoticias(listNoticias)
            }

        }

        configurationDrawer()
    }

    override fun onItemClick(noticia: NoticiaFirebase) {

        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("noticia_titulo", noticia.title)
        intent.putExtra("noticia_image", noticia.image)
        intent.putExtra("noticia_contenido", noticia.description)
        startActivity(intent)
    }


    fun configurationDrawer() {

        val navView = findViewById<NavigationView>(R.id.navigation_view)
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        navView.setNavigationItemSelectedListener { menuItem ->

            drawerLayout.closeDrawer(GravityCompat.START)

            when(menuItem.itemId) {
                R.id.nav_home -> {
                    // sdsdsdszdsdsdsd
                    true
                }
                R.id.nav_perfil -> {
                    // sdsdsdszdsdsdsd
                    true
                }
                R.id.nav_mapas -> {
                    // sdsdsdszdsdsdsd
                    startActivity(Intent(this, MapasActivity::class.java))
                    true
                }
                else -> {
                    false
                }
            }

        }

    }

}