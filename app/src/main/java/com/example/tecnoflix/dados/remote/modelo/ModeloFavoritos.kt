package com.example.tecnoflix.dados.remote.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class ModeloFavoritos (
    val title: String,
    val capaImagem: String
        ){
    @PrimaryKey(autoGenerate = true)
        var id : Int = 0
}