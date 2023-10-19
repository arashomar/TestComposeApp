package com.example.testcomposeapp.Managers

import java.util.Date

class LoginManager {

    /*
    * A function that validates an email address
    * @param email: the email address to validate
    * @return true if the email is valid, false otherwise
    *
     */
    fun verifyEmail(email: String): Boolean {
        return email.contains("@")

        //Todo create a regex pattern to match email addresses
    }
}






