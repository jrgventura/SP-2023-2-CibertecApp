package com.cibertec.cibertecapp.login

import android.app.Activity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cibertec.cibertecapp.network.response.LoginResponse
import com.cibertec.cibertecapp.network.response.User
import com.cibertec.cibertecapp.network.response.UsersResponse
import com.google.firebase.auth.FirebaseAuth
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel: ViewModel() {

    private lateinit var authFirebase: FirebaseAuth

    private val repository = LoginRepository()
    private val disposable = CompositeDisposable()

    val userLoginService = MutableLiveData<Boolean>()
    val userUserListService = MutableLiveData<ArrayList<User>>()

    fun login(email: String, pass: String) {
        // loginService(email, pass)
        loginFirebase(email, pass)
    }

    private fun loginService(email: String, pass: String) {
        disposable.add(
            repository.login(email, pass)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<LoginResponse>() {

                    override fun onSuccess(t: LoginResponse) {
                        userLoginService.value = true
                    }

                    override fun onError(e: Throwable) {
                        userLoginService.value = false
                    }

                })
        )
    }

    private fun userService(id: Int) {
        disposable.add(
            repository.buscarUsuario(id)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<UsersResponse>() {

                    override fun onSuccess(t: UsersResponse) {

                        var dataRecycler: ArrayList<User> = t.data
                        userUserListService.value = dataRecycler

                    }

                    override fun onError(e: Throwable) {

                    }

                })
        )
    }

    private fun loginFirebase(email: String, pass: String) {
        authFirebase = FirebaseAuth.getInstance()
        authFirebase.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(Activity()) { task ->

                userLoginService.value = task.isSuccessful

            }
    }

}