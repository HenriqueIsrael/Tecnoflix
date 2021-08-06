package com.example.tecnoflix.repository

import com.example.tecnoflix.dados.local.database.FavoritoDAO
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos

class FavoritoRepository(private val favoritoDAO: FavoritoDAO) {
    fun salvarFavorito(
        titulo: String,
        capaImagem: String,
        dataLancamento: String,
        classificacaoFilme: String,
        numeroVotos: String,
        sinopse: String
    ) {
        favoritoDAO.inserirFavorito(
            ModeloFavoritos(
                titulo,
                capaImagem,
                dataLancamento,
                classificacaoFilme,
                numeroVotos,
                sinopse
            )
        )
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
