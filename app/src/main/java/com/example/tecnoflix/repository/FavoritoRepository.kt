package com.example.tecnoflix.repository

import com.example.tecnoflix.dados.local.database.FavoritoDAO
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos

class FavoritoRepository(private val favoritoDAO: FavoritoDAO) {
    fun salvarFavorito(titulo: String, capaImagem: String) {
        favoritoDAO.inserirFavorito(ModeloFavoritos(titulo, capaImagem))
    }

    fun getListaFavoritos(): List<ModeloFavoritos> {
        return favoritoDAO.returnListaDeFavoritos()
    }

    fun deletaFilme(titulo: String) {
        favoritoDAO.deletaFilmeFavorito(titulo)
    }

    fun buscaFilme(titulo: String): String {
        return favoritoDAO.buscaFilmeFavorito(titulo)
    }
}
