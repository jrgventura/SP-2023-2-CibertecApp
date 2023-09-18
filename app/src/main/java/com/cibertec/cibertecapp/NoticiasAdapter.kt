package com.cibertec.cibertecapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NoticiasAdapter(val list: List<Noticia>):
    RecyclerView.Adapter<NoticiasViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            NoticiasViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NoticiasViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: NoticiasViewHolder, position: Int) {
        val noticia: Noticia = list[position]
        holder.bind(noticia)
    }


}