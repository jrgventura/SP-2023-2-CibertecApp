package com.cibertec.cibertecapp.notas

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.database.Nota

class NotasViewHolder(inflater: LayoutInflater, parent: ViewGroup):
RecyclerView.ViewHolder(inflater.inflate(R.layout.item_nota, parent, false)){

    private var textNoteDate: TextView? = null
    private var textNoteTitle: TextView? = null
    private var textNoteDescription: TextView? = null

    init {
        textNoteDate = itemView.findViewById(R.id.textNoteDate)
        textNoteTitle = itemView.findViewById(R.id.textNoteTitle)
        textNoteDescription = itemView.findViewById(R.id.textNoteDescription)
    }

    fun bind(nota: Nota) {
        textNoteDate?.text = nota.date
        textNoteTitle?.text = nota.title
        textNoteDescription?.text = nota.description
    }

}









