package com.example.tecnoflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import com.example.tecnoflix.repository.ViewPagerRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class ViewPagerViewModel(private val viewPagerRepository: ViewPagerRepository): ViewModel() {

    private val _viewPagerLiveData = MutableLiveData<ModeloFilmes>()
    val viewPagerLiveData: LiveData<ModeloFilmes> = _viewPagerLiveData

    private val _viewPagerErroLiveData = MutableLiveData<String>()
    val viewPagerErroLiveData: LiveData<String> = _viewPagerErroLiveData

    private lateinit var dataInicio: String
    private lateinit var dataFinal: String

    fun getFilmesCartaz() {
        viewModelScope.launch {
            try {
                getData()
                val response = viewPagerRepository.getFilmesCartaz(dataFinal, dataInicio)
                _viewPagerLiveData.postValue(response)
            } catch (e: Exception) {
                _viewPagerErroLiveData.postValue(e.message)
            }
        }
    }
    private fun getData(){
        dataInicio = SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().apply {
            add(Calendar.DAY_OF_MONTH,-30)
        }.time)
        dataFinal = SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().time)
    }
}
