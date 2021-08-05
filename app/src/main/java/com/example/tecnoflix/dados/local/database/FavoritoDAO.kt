package com.example.tecnoflix.dados.local.database

import androidx.room.*
import com.example.tecnoflix.dados.remote.modelo.ModeloFavoritos

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

//    @Query("SELECT title,capaImagem,dataLancamento,avaliacao,numVotos,sinopse FROM  ModeloFavoritos WHERE title = :titulo")
//    fun retornaDadosFilmes(titulo: String): Array<String>
}
