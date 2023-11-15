package com.cibertec.cibertecapp.noticias

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.cibertec.cibertecapp.R

class NoticiasViewHolder (inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(
        R.layout.item_news, parent,
    false)){

    private var imgPortada: ImageView? = null
    private var textTitle: TextView? = null
    private var textDescription: TextView? = null

    init {
        imgPortada = itemView.findViewById(R.id.imgPortada)
        textTitle = itemView.findViewById(R.id.textNewsTitle)
        textDescription = itemView.findViewById(R.id.textNewsDescription)
    }

    fun bind(noticia: NoticiaFirebase) {
        textTitle?.text = noticia.title
        textDescription?.text = noticia.description

        val options = RequestOptions()
            .placeholder(R.drawable.logo)
            .error(R.drawable.logo)

        imgPortada?.let {
            Glide.with(it)
                .setDefaultRequestOptions(options)
                .load(noticia.image)
                .into(it)
        }

    }

}
