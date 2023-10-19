package com.example.testcomposeapp

import com.example.testcomposeapp.Managers.LoginManager
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val loginManager = LoginManager()
        val isValid = loginManager.verifyEmail("test@test.com")
        assertEquals(true, isValid)

    }


    // write a test for LoginManager.verifyEmail()


}