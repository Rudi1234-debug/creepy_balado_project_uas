package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val usernameLD = MutableLiveData<String>()
    val passwordLD = MutableLiveData<String>()
    val loginSuccessLD = MutableLiveData<Boolean>()
    val loginErrorLD = MutableLiveData<Boolean>()

    private val userDatabase = mapOf(
        "Rudi Novianto" to "12345678",
        "Aurelius Prasetio" to "12345678",
        "Gede Januarta" to "12345678"
    )

    private val preferences: SharedPreferences =
        application.getSharedPreferences("login_prefs", Context.MODE_PRIVATE)

    init {
        checkLoggedInStatus()
    }

    private fun checkLoggedInStatus() {
        val loggedIn = preferences.getBoolean("logged_in", false)
        loginSuccessLD.value = loggedIn
    }

    fun onLoginClicked() {
        val username = usernameLD.value
        val password = passwordLD.value

        if (username != null && password != null) {
            if (userDatabase[username] == password) {
                preferences.edit().putBoolean("logged_in", true).apply()
                loginSuccessLD.value = true
                loginErrorLD.value = false
            } else {
                loginSuccessLD.value = false
                loginErrorLD.value = true
            }
        } else {
            loginSuccessLD.value = false
            loginErrorLD.value = true
        }
    }

    fun logout() {
        preferences.edit().putBoolean("logged_in", false).apply()
        loginSuccessLD.value = false
    }
}
