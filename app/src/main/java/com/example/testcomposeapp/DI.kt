package com.example.testcomposeapp

import com.example.testcomposeapp.Managers.LoginManager
import com.example.testcomposeapp.login.LoginViewModel
import com.example.testcomposeapp.magic8ball.Magic8BallResponsesRepository
import com.example.testcomposeapp.magic8ball.Magic8BallViewModel

class DI {

    companion object {
        private val loginManager = LoginManager()
        val loginViewModel = LoginViewModel(loginManager)

        val magic8BallViewModel = Magic8BallViewModel(Magic8BallResponsesRepository())
    }
}