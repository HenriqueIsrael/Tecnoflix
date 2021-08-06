package com.example.tecnoflix.repository

import com.example.tecnoflix.dados.local.database.FavoritoDAO
import com.example.tecnoflix.dados.remote.modelo.ModeloLogin

class CadastroRepository(private val usuarioDAO: FavoritoDAO) {
     fun insereUsuario(
          email: String,
          senha: String
     ){
         usuarioDAO.inserirUsuario(ModeloLogin(email,senha))
     }


}
