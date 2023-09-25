package com.cibertec.cibertecapp

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class MenuActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val intent = intent
        val titulo = intent.getStringExtra("noticia_titulo")
        val imagen = intent.getIntExtra("noticia_image", 0)
        val contenido = intent.getStringExtra("noticia_contenido")

        val textTitle = findViewById<TextView>(R.id.textTitle)
        textTitle.text = titulo

    }

}