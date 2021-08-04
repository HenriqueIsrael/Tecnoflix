package com.example.tecnoflix.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tecnoflix.repository.ViewPagerRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ViewPagerViewModel(private val viewPagerRepository: ViewPagerRepository): ViewModel() {


    fun getFilmesCartaz(dataInicial: String, dataFinal: String){
        viewModelScope.launch {
            try{
                viewPagerRepository.getFilmesCartaz(dataFinal,dataInicial)
            } catch (e:Exception){

            }

        }

    }

}