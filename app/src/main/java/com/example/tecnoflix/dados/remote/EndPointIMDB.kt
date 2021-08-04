package com.example.tecnoflix.dados.remote

import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface EndPointIMDB {
    @GET("movie/popular")
    suspend fun getFilmesPopulares(
        @Query("api_key") chaveapi: String,
        @Query("language") linguagem: String
    ): Response<ModeloFilmes>

    @GET("search/movie")
    suspend fun getPesquisaTitulo(
        @Query("api_key") chaveapi: String,
        @Query("query") nomeDoFilme: String
    ): Response<ModeloFilmes>

    @GET("discover/movie")
    suspend fun getFilmesCartaz(
        @Query("api_key") chaveapi: String,
        @Query("primary_release_date.gte") dataInicial: String,
        @Query("primary_release_date.lte") dataFinal : String,
        @Query("language") linguagem: String
    ): Response<ModeloFilmes>

    companion object {
        fun getEndPointInstance(): EndPointIMDB {
            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(EndPointIMDB::class.java)
        }
    }
}