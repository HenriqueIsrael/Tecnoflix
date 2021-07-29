package com.example.tecnoflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import com.example.tecnoflix.repository.HomeRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _listaFilmesLiveData = MutableLiveData <ModeloFilmes>()
    val listaFilmesLiveData: LiveData<ModeloFilmes> = _listaFilmesLiveData

    private val _erroLiveData = MutableLiveData <String>()
    val erroLiveData: LiveData<String> = _erroLiveData

    fun getFilmesPopulares() {
       viewModelScope.launch {
       try{
           val response = homeRepository.getFilmesPopulares()
           _listaFilmesLiveData.postValue(response)

       } catch (e: Exception){
           _erroLiveData.postValue(e.message)
       }

       }
    }
}
