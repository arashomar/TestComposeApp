package com.example.testcomposeapp.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.testcomposeapp.Managers.LoginManager

class LoginViewModel(
    private val loginManager: LoginManager
) : ViewModel() {

    var name by mutableStateOf("")

    var email by mutableStateOf("")

    fun validateEmail(): Boolean {
        return loginManager.verifyEmail(email)
    }

    fun onNameChanged(name: String) {
        this.name = name
    }

    fun onEmailChanged(email: String) {
        this.email = email
    }
}