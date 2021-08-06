package com.example.tecnoflix.repository

import com.example.tecnoflix.SharedPreferenceService
import com.example.tecnoflix.dados.local.database.FavoritoDAO
import com.example.tecnoflix.dados.remote.modelo.ModeloLogin

class LoginRepository(
    private val sharedPreferenceService: SharedPreferenceService,
    private val usuarioDAO: FavoritoDAO
) {

    fun saveLogin(email: String, senha: String) {
        sharedPreferenceService.saveLogin(email,senha)
    }

    fun getEmail(): String {
       return sharedPreferenceService.getEmail()!!
    }

    fun getSenha(): String {
        return sharedPreferenceService.getSenha()!!
    }
    fun buscaUsuarios(
        email: String
    ): ModeloLogin {
        return usuarioDAO.retornaUsuarios(email)
    }
}