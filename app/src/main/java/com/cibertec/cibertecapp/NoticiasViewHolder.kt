package com.cibertec.cibertecapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoticiasViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_news, parent,
    false)){

    private var imgPortada: ImageView? = null
    private var textTitle: TextView? = null
    private var textDescription: TextView? = null

    init {
        imgPortada = itemView.findViewById(R.id.imgPortada)
        textTitle = itemView.findViewById(R.id.textNewsTitle)
        textDescription = itemView.findViewById(R.id.textNewsDescription)
    }

    fun bind(noticia: Noticia) {
        textTitle?.text = noticia.title
        textDescription?.text = noticia.description
        imgPortada?.setImageResource(noticia.image)
    }

}
