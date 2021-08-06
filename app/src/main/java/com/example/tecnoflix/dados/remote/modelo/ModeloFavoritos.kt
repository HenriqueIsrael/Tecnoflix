package com.example.tecnoflix.dados.remote.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class ModeloFavoritos(
    val title: String,
    val capaImagem: String,
    val dataLancamento: String,
    val avaliacao: String,
    val numVotos: String,
    val sinopse: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}