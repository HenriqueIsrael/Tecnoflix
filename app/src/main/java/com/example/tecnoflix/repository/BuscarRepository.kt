package com.example.tecnoflix.repository

import com.example.tecnoflix.dados.remote.EndPointIMDB
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import com.example.tecnoflix.repository.HomeRepository.Companion.CHAVE_API
import com.example.tecnoflix.repository.HomeRepository.Companion.LINGUAGEM
import java.lang.Exception

class BuscarRepository(private val endPoint: EndPointIMDB) {

    suspend fun pesquisaFilme(nomeDoFilme: String): ModeloFilmes{
        val response = endPoint.getPesquisaTitulo(CHAVE_API, nomeDoFilme,LINGUAGEM)
        if(response.isSuccessful){
            return response.body()!!
        } else{
            throw Exception("Erro 204")
        }
    }
}
