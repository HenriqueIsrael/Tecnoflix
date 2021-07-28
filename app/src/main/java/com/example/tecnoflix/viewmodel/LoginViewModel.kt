package com.example.tecnoflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecnoflix.repository.LoginRepository

class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _emailLiveData = MutableLiveData <String>()
    val emailLiveData: LiveData <String> = _emailLiveData

    private val _senhaLiveData = MutableLiveData <String>()
    val senhaLiveData: LiveData <String> = _senhaLiveData

    fun saveLogin(email: String, senha: String) {
        loginRepository.saveLogin(email, senha)
    }

    fun getEmail() {
        _emailLiveData.postValue(loginRepository.getEmail())
    }

    fun getSenha() {
        _senhaLiveData.postValue(loginRepository.getSenha())
    }
}
