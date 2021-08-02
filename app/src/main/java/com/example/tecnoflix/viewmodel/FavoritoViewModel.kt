package com.example.tecnoflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos
import com.example.tecnoflix.repository.FavoritoRepository

class FavoritoViewModel(private val favoritoRepository: FavoritoRepository): ViewModel() {

    private val _listaFilmesFavoritoLiveData = MutableLiveData <List<ModeloFavoritos>>()
    val listaFilmesFavoritoLiveData: LiveData<List<ModeloFavoritos>> = _listaFilmesFavoritoLiveData

    fun enviaFilme(titulo: String, capaImagem: String){
        favoritoRepository.salvarFavorito(titulo,capaImagem)
    }
    fun getListaFilme(){
        _listaFilmesFavoritoLiveData.postValue(favoritoRepository.getListaFavoritos())
    }
}
