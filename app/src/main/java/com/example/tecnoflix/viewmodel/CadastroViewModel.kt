package com.example.tecnoflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecnoflix.dados.remote.modelo.ModeloLogin
import com.example.tecnoflix.repository.CadastroRepository

class CadastroViewModel(private val cadastroRepository: CadastroRepository): ViewModel() {

    fun insereUsuario(
        email: String,
        senha: String
    ){
        cadastroRepository.insereUsuario(email,senha)
    }
}