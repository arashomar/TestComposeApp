package com.example.testcomposeapp

import com.example.testcomposeapp.Managers.LoginManager
import com.example.testcomposeapp.login.LoginViewModel

class DI {

    companion object {
        private val loginManager = LoginManager()
        val loginViewModel = LoginViewModel(loginManager)
    }
}