package com.cibertec.cibertecapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoticiasAdapter(val mItemClickListener: ItemClickNoticia):
    RecyclerView.Adapter<NoticiasViewHolder>() {

    private var noticiasList = emptyList<Noticia>()

    fun setNoticias(noticias: List<Noticia>) {
        this.noticiasList = noticias
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            NoticiasViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoticiasViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return noticiasList.size
    }

    override fun onBindViewHolder(holder: NoticiasViewHolder, position: Int) {
        val noticia: Noticia = noticiasList[position]
        holder.bind(noticia)

        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(noticia)
        }
    }

    // Evento
    interface ItemClickNoticia {
        fun onItemClick(noticia: Noticia)
    }


}