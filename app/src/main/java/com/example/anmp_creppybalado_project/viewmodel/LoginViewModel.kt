package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.anmp_creppybalado_project.model.ModelDatabase
import com.example.anmp_creppybalado_project.model.User
import kotlinx.coroutines.launch

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    val usernameLD = MutableLiveData<String>()
    val passwordLD = MutableLiveData<String>()
    val loginSuccessLD = MutableLiveData<Boolean>()
    val loginErrorLD = MutableLiveData<Boolean>()
    val navigateToLogin = MutableLiveData<Boolean>()

    companion object {
        var currentUser: User? = null
    }
    private val userDao = ModelDatabase.buildDatabase(application).userDao()


    fun onLoginClicked() {
        val username = usernameLD.value
        val password = passwordLD.value

        if (username != null && password != null) {
            viewModelScope.launch {
                val user = userDao.getUser(username, password)
                if (user != null) {
                    currentUser = user
                    loginSuccessLD.value = true
                    loginErrorLD.value = false

                    val sharedPreferences = getApplication<Application>().getSharedPreferences("user_session", Context.MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("username", username)
                    editor.putString("password", password)
                    editor.putBoolean("is_logged_in", true)
                    editor.apply()
                } else {
                    loginSuccessLD.value = false
                    loginErrorLD.value = true

                }
            }
        } else {
            loginSuccessLD.value = false
            loginErrorLD.value = true
        }
    }

    fun logout() {
        currentUser = null
        loginSuccessLD.value = false

        val sharedPreferences = getApplication<Application>().getSharedPreferences("user_session", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

        navigateToLogin.value = true
    }
}
