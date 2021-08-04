package com.example.tecnoflix.repository

import com.example.tecnoflix.dados.remote.EndPointIMDB
import com.example.tecnoflix.dados.remote.modelo.ModeloFilmes
import com.example.tecnoflix.repository.HomeRepository.Companion.CHAVE_API
import java.lang.Exception

class ViewPagerRepository(private val EndPoint: EndPointIMDB) {
    suspend fun getFilmesCartaz(dataFinal: String, dataInicial: String): ModeloFilmes {
        val response = EndPoint.getFilmesCartaz(CHAVE_API,dataInicial,dataFinal)

        if(response.isSuccessful){
            return response.body()!!
        } else {
            throw Exception("Erro!")
        }
    }
}