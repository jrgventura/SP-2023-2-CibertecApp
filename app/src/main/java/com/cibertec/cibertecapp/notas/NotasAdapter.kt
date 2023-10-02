package com.cibertec.cibertecapp.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.database.Nota

class NotasAdapter (val mItemClickListener: ItemClickListener):
RecyclerView.Adapter<NotasViewHolder>() {

    private var notaList = emptyList<Nota>()

    fun setNotas(notas: List<Nota>) {
        this.notaList = notas
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotasViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return NotasViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return notaList.size
    }

    override fun onBindViewHolder(holder: NotasViewHolder, position: Int) {
        val nota: Nota = notaList[position]
        holder.bind(nota)
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(nota)
        }
    }

    interface ItemClickListener{
        fun onItemClick(nota: Nota)
    }

}