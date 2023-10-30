package com.cibertec.cibertecapp.registro

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class RegisterViewModel: ViewModel() {

    private lateinit var authFirebase: FirebaseAuth

    val userRegisterService = MutableLiveData<Boolean>()

    fun register(email: String, pass: String) {
        registerFirebase(email, pass)
    }

    private fun registerFirebase(email: String, pass: String) {
        authFirebase = FirebaseAuth.getInstance()
        authFirebase.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(Activity()) { task ->
                userRegisterService.value = task.isSuccessful
            }
    }

}