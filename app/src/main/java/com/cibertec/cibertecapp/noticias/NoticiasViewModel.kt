package com.cibertec.cibertecapp.noticias

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class NoticiasViewModel : ViewModel() {

    private lateinit var firestore: FirebaseFirestore

    val listNoticiasMutable = MutableLiveData<List<NoticiaFirebase>>()

    fun getNoticiasFirebase() {
        firestore = FirebaseFirestore.getInstance()
        firestore.collection("noticias").get()
            .addOnSuccessListener { documentList ->
                var listNoticias = arrayListOf<NoticiaFirebase>()
                for (document in documentList) {
                    val titulo = document.getString("titulo")
                    val contenido = document.getString("contenido")
                    val imagen = document.getString("imagen")

                    if (titulo!=null && contenido!=null && imagen!=null) {
                        val noticia = NoticiaFirebase(titulo, contenido, imagen)
                        listNoticias.add(noticia)
                    }
                }
                listNoticiasMutable.value = listNoticias
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "Error getting documents: ", exception)
            }
    }

}