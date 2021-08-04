package com.example.tecnoflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import com.example.tecnoflix.repository.ViewPagerRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ViewPagerViewModel(private val viewPagerRepository: ViewPagerRepository): ViewModel() {

    private val _viewPagerLiveData = MutableLiveData<ModeloFilmes>()
    val viewPagerLiveData: LiveData<ModeloFilmes> = _viewPagerLiveData

    private val _viewPagerErroLiveData = MutableLiveData<String>()
    val viewPagerErroLiveData: LiveData<String> = _viewPagerErroLiveData

    fun getFilmesCartaz(dataInicial: String, dataFinal: String) {
        viewModelScope.launch {
            try {
                val response = viewPagerRepository.getFilmesCartaz(dataFinal, dataInicial)
                _viewPagerLiveData.postValue(response)
            } catch (e: Exception) {
                _viewPagerErroLiveData.postValue(e.message)
            }
        }
    }
}
