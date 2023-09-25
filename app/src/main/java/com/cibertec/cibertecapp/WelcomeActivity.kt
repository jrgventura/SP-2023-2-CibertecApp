package com.cibertec.cibertecapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class WelcomeActivity: AppCompatActivity(), NoticiasAdapter.ItemClickNoticia {

    private val listNoticias = listOf(
        Noticia("¿PORQUÉ INVERTIR EN UNA ESPECIALIZACIÓN?",
            "Una especialización se refiere a la",
            R.drawable.noticia1),
        Noticia("¿POR QUÉ DEBES ESTUDIAR COMPUTACIÓN E INFORMÁTICA?\n", "La pandemia no solo cambió la forma de trabajo en las empresas, sino también aceleró su digitalización. A consecuencia de ello, la demanda de perfiles tecnológicos se incrementó, siendo el más requerido las personas dedicadas a la Computación e Informática.\n" +
                "\n", R.drawable.noticia2),
        Noticia("¿DE QUÉ TRATA LA CARRERA DE ANIMACIÓN DIGITAL?\n", "En la carrera animación digital todos tenemos acceso ilimitado para crear arte cuando y como queramos con la tecnología. Los profesionales de la animación digital pueden trabajar para empresas de cine y televisión, agencias de publicidad, la industria de los videojuegos o muchas otras industrias que utilizan las habilidades creativas.\n" +
                "\n", R.drawable.noticia3),
        Noticia("¿DE QUÉ TRATA LA CARRERA DE ANIMACIÓN DIGITAL?\n", "En la carrera animación digital todos tenemos acceso ilimitado para crear arte cuando y como queramos con la tecnología. Los profesionales de la animación digital pueden trabajar para empresas de cine y televisión, agencias de publicidad, la industria de los videojuegos o muchas otras industrias que utilizan las habilidades creativas.\n" +
                "\n", R.drawable.noticia3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val recyclerNews = findViewById<RecyclerView>(R.id.recyclerNews)
        /*recyclerNews.apply {
            // layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            // layoutManager = GridLayoutManager(context, 2)
            layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            adapter = NoticiasAdapter(listNoticias)
        }*/

        val adapter = NoticiasAdapter(this)
        recyclerNews.adapter = adapter
        recyclerNews.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)
        adapter.setNoticias(listNoticias)


    }

    override fun onItemClick(noticia: Noticia) {

        val intent = Intent(this, MenuActivity::class.java)
        intent.putExtra("noticia_titulo", noticia.title)
        intent.putExtra("noticia_image", noticia.image)
        intent.putExtra("noticia_contenido", noticia.description)
        startActivity(intent)
    }


}