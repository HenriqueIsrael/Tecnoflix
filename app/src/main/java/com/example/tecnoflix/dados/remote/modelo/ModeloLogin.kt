package com.example.tecnoflix.dados.remote.modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ModeloLogin(
    val email: String,
    val senha: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
