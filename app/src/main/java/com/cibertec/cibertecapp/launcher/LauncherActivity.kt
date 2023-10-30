package com.cibertec.cibertecapp.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.cibertec.cibertecapp.R
import com.cibertec.cibertecapp.WelcomeActivity
import com.cibertec.cibertecapp.login.LoginActivity
import com.cibertec.cibertecapp.login.LoginViewModel

class LauncherActivity: AppCompatActivity() {

    private lateinit var viewModel: LauncherViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        viewModel = ViewModelProvider(this)[LauncherViewModel::class.java]
        viewModel.verifySession()

        observerViewModel()

    }

    private fun observerViewModel() {
        viewModel.userSessionService.observe(this) {
            if (it) {
                startActivity(Intent(this, WelcomeActivity::class.java))
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
            }
        }
    }

}