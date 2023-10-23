package com.cibertec.cibertecapp.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cibertec.cibertecapp.network.response.LoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class LoginViewModel: ViewModel() {

    private val repository = LoginRepository()
    private val disposable = CompositeDisposable()
    val userLoginService = MutableLiveData<Boolean>()

    fun login(email: String, pass: String) {
        loginService(email, pass)
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

}