package com.example.tecnoflix.dados.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos

@Dao
interface FavoritoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirFavorito(modeloFavorito: ModeloFavoritos)

    @Query("SELECT * FROM ModeloFavoritos")
    fun returnListaDeFavoritos(): List<ModeloFavoritos>
}