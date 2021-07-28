package com.example.tecnoflix.repository

import com.example.tecnoflix.SharedPreferenceService

class LoginRepository(private val sharedPreferenceService: SharedPreferenceService) {

    fun saveLogin(email: String, senha: String) {
        sharedPreferenceService.saveLogin(email,senha)
    }

    fun getEmail(): String {
       return sharedPreferenceService.getEmail()!!
    }

    fun getSenha(): String {
        return sharedPreferenceService.getSenha()!!
    }
}