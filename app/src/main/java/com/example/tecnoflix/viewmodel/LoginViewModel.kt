package com.example.tecnoflix.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tecnoflix.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    fun saveLogin(email: String, senha: String) {
        loginRepository.saveLogin(email, senha)
    }

    fun getEmail() {

    }

    fun getSenha() {

    }
}