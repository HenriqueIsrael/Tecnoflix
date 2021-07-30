package com.example.tecnoflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import com.example.tecnoflix.repository.BuscarRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class BuscarViewModel(private val buscarRepository: BuscarRepository) : ViewModel() {

    private val _listaPesquisadaLiveData = MutableLiveData<ModeloFilmes>()
    val listaPesquisadaLiveData: LiveData<ModeloFilmes> = _listaPesquisadaLiveData

    private val _erroLiveData = MutableLiveData<String>()
    val erroLiveData: LiveData<String> = _erroLiveData

    fun pesquisaFilme(nomeDoFilme: String) {
        viewModelScope.launch {
            try {
                val response = buscarRepository.pesquisaFilme(nomeDoFilme)
                _listaPesquisadaLiveData.postValue(response)
            }
            catch (e: Exception) {
                _erroLiveData.postValue(e.message)
            }
        }
    }
}
