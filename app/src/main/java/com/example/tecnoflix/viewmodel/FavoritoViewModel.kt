package com.example.tecnoflix.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos
import com.example.tecnoflix.repository.FavoritoRepository

class FavoritoViewModel(private val favoritoRepository: FavoritoRepository): ViewModel() {

    private val _listaFilmesFavoritoLiveData = MutableLiveData <List<ModeloFavoritos>>()
    val listaFilmesFavoritoLiveData: LiveData<List<ModeloFavoritos>> = _listaFilmesFavoritoLiveData

    private val _buscaFilmesFavoritoLiveData = MutableLiveData <String>()
    val buscaFilmesFavoritoLiveData: LiveData<String> = _buscaFilmesFavoritoLiveData

    private val _coracaoColorido = MutableLiveData<Boolean>()
    val coracaoColorido: LiveData<Boolean> = _coracaoColorido

    private val _controleSalvaOuDeleta = MutableLiveData<Boolean>()
    val controleSalvaOuDeleta: LiveData<Boolean> = _controleSalvaOuDeleta

    fun enviaFilme(titulo: String, capaImagem: String){
        favoritoRepository.salvarFavorito(titulo,capaImagem)
    }
    fun getListaFilme(){
        _listaFilmesFavoritoLiveData.postValue(favoritoRepository.getListaFavoritos())
    }

    fun deletaFilme(titulo: String) {
        favoritoRepository.deletaFilme(titulo)
    }

    fun buscaFilme (titulo: String) {
        if(favoritoRepository.buscaFilme(titulo).isNullOrEmpty()){
            _coracaoColorido.postValue(false)
        }else{
            _coracaoColorido.postValue(true)
        }
    }

    fun cliqueNoBotaoFavorito(){
        if (coracaoColorido.value == true) {
            _coracaoColorido.postValue(false)
            _controleSalvaOuDeleta.postValue(false)
        } else {
            _coracaoColorido.postValue(true)
            _controleSalvaOuDeleta.postValue(true)
        }
    }
}
