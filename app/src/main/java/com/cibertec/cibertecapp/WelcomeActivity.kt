package com.cibertec.cibertecapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class WelcomeActivity: AppCompatActivity() {

    private val listNoticias = listOf(
        Noticia("¿PORQUÉ INVERTIR EN UNA ESPECIALIZACIÓN?",
            "Una especialización se refiere a la adquisición de conocimientos, habilidades y experiencia más detallados y profundos en un área específica de estudio o práctica",
            R.drawable.noticia1),
        Noticia("¿POR QUÉ DEBES ESTUDIAR COMPUTACIÓN E INFORMÁTICA?\n", "La pandemia no solo cambió la forma de trabajo en las empresas, sino también aceleró su digitalización. A consecuencia de ello, la demanda de perfiles tecnológicos se incrementó, siendo el más requerido las personas dedicadas a la Computación e Informática.\n" +
                "\n", R.drawable.noticia2),
        Noticia("¿DE QUÉ TRATA LA CARRERA DE ANIMACIÓN DIGITAL?\n", "En la carrera animación digital todos tenemos acceso ilimitado para crear arte cuando y como queramos con la tecnología. Los profesionales de la animación digital pueden trabajar para empresas de cine y televisión, agencias de publicidad, la industria de los videojuegos o muchas otras industrias que utilizan las habilidades creativas.\n" +
                "\n", R.drawable.noticia3)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val recyclerNews = findViewById<RecyclerView>(R.id.recyclerNews)

    }



}