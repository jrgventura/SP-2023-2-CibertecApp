package com.cibertec.cibertecapp.notas

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.database.Nota
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NotasActivity: AppCompatActivity(), NotasAdapter.ItemClickListener {

    private lateinit var notaViewModel: NotasViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

        notaViewModel = run {
            ViewModelProvider(this)[NotasViewModel::class.java]
        }

        val fabNuevaNota = findViewById<FloatingActionButton>(R.id.fabNuevaNota)
        fabNuevaNota.setOnClickListener {
            registerNota(null, tipo = 0)
        }

        val recyclerNotas = findViewById<RecyclerView>(R.id.recyclerNotas)

        val adapter = NotasAdapter(this)
        recyclerNotas.adapter = adapter
        recyclerNotas.layoutManager = LinearLayoutManager(this)

        notaViewModel.notas?.observe(this){ notas ->
            notas?.let {
                adapter.setNotas(notas)
            }
        }

    }

    fun registerNota(nota: Nota?, tipo: Int) {
        val mDialogView = LayoutInflater.from(this)
            .inflate(R.layout.dialog_note, null)

        val titleAlertNota = if (tipo == 0) "Registrar" else "Editar"

        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle(titleAlertNota)

        val mAlertDialog = mBuilder.show()

        val edtTitleNote = mDialogView.findViewById<EditText>(R.id.edtTitleNote)
        val edtDescNote = mDialogView.findViewById<EditText>(R.id.edtDescNote)
        val btnCreate = mDialogView.findViewById<Button>(R.id.btnCreate)

        if (tipo == 1) {
            edtTitleNote.setText(nota?.title)
            edtDescNote.setText(nota?.description)
        }

        btnCreate.setOnClickListener {
            mAlertDialog.dismiss()

            val title = edtTitleNote.text.toString()
            val description = edtDescNote.text.toString()
            val date = formatDate(LocalDateTime.now())

            if (tipo == 0) {
                var nota = Nota(title, description, date)
                notaViewModel.saveNoteWithCoroutines(nota)
            } else {
                var notaV = Nota(title, description, date)
                notaV.noteId = nota?.noteId!!
                notaViewModel.upateNoteWithCoroutines(notaV)
            }

        }

    }

    fun formatDate(date: LocalDateTime): String {
        // 02/10/2023 15:54:00
        val format = "dd/MM/yyyy HH:mm:ss"
        return date.format(DateTimeFormatter.ofPattern(format))
    }

    override fun onItemClick(nota: Nota) {
        registerNota(nota, tipo = 1)
    }


}