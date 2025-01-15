package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.anmp_creppybalado_project.model.ModelDatabase
import com.example.anmp_creppybalado_project.model.User
import kotlinx.coroutines.launch

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    val firstNameLD = MutableLiveData<String>()
    val lastNameLD = MutableLiveData<String>()
    val usernameLD = MutableLiveData<String>()
    val passwordLD = MutableLiveData<String>()
    val registerSuccessLD = MutableLiveData<Boolean>()

    private val userDao = ModelDatabase.buildDatabase(application).userDao()

    fun onRegisterClicked() {
        val firstName = firstNameLD.value
        val lastName = lastNameLD.value
        val username = usernameLD.value
        val password = passwordLD.value

        if (firstName != null && lastName != null && username != null && password != null) {
            val newUser = User(firstName, lastName, username, password)
            viewModelScope.launch {
                userDao.insertUser(newUser)
                registerSuccessLD.value = true
            }
        } else {
            registerSuccessLD.value = false
        }
    }
}
