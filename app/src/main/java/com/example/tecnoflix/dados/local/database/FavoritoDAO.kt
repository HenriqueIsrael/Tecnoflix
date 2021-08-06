package com.example.tecnoflix.dados.local.database

import androidx.room.*
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos
import com.example.tecnoflix.dados.remote.modelo.ModeloLogin

//    CRUD
//    C -> Create criação
//    R -> Read leitura
//    U -> Update atualização
//    D -> Delete Deletar
@Dao
interface FavoritoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirFavorito(modeloFavorito: ModeloFavoritos)

    @Query("SELECT * FROM ModeloFavoritos")
    fun returnListaDeFavoritos(): List<ModeloFavoritos>

    @Query("DELETE FROM ModeloFavoritos WHERE title = :titulo")
    fun deletaFilmeFavorito(titulo: String)

    @Query("SELECT title FROM  ModeloFavoritos WHERE title = :titulo")
    fun buscaFilmeFavorito(titulo: String): String

    @Query("SELECT * FROM  ModeloFavoritos WHERE title = :titulo")
    fun retornaDadosFilmes(titulo: String): ModeloFavoritos

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirUsuario(usuario: ModeloLogin)

    @Query("SELECT * FROM  ModeloLogin WHERE email = :email")
    fun retornaUsuarios(email: String): ModeloLogin
}
