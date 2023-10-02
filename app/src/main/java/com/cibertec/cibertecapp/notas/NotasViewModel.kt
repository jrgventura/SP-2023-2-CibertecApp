package com.cibertec.cibertecapp.notas

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.cibertec.cibertecapp.database.Nota
import kotlinx.coroutines.launch

class NotasViewModel (application: Application): AndroidViewModel(application) {

    private val repository = NotasRepository(application)



    fun saveNoteWithCoroutines(nota: Nota) {
        viewModelScope.launch {
            repository.insertNotaWithCoroutines(nota)
        }
    }

}