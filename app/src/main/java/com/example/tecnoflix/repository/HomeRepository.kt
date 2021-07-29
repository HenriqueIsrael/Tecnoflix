package com.example.tecnoflix.repository

import com.example.tecnoflix.dados.remote.EndPointIMDB
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import java.lang.Exception

class HomeRepository(private val endPoint: EndPointIMDB) {

    suspend fun getFilmesPopulares(): ModeloFilmes{
        val response = endPoint.getFilmesPopulares(CHAVE_API, LINGUAGEM)
        if(response.isSuccessful) {
            return response.body()!!
        } else {
            throw Exception("Erro 204")
        }
    }


    companion object{
        private const val CHAVE_API = "c87a59110d1715855dac83ccfc5c2640"
        private const val LINGUAGEM = "pt-BR"
    }
}
