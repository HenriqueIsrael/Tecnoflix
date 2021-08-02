package com.example.tecnoflix.dados.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos

@Database(entities = [ModeloFavoritos::class], version = 1, exportSchema = false)
abstract class FavoritoDatabase : RoomDatabase() {
    abstract fun favoritoDAO(): FavoritoDAO

    companion object {
        fun getInstanceDatabase(context: Context?): FavoritoDatabase {
            return Room.databaseBuilder(context!!, FavoritoDatabase::class.java, "Filmes Favoritos")
                .allowMainThreadQueries().build()
        }
    }
}