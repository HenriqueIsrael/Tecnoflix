package com.example.tecnoflix

import android.content.SharedPreferences
import androidx.core.content.edit

class SharedPreferenceService(private val preference: SharedPreferences) {

    fun getEmail(): String?{
        return preference.getString("email","")
    }

    fun getSenha(): String?{
        return preference.getString("senha","")
    }

    fun saveLogin(email: String, senha: String) {
        preference.edit {
            putString("email",email)
            putString("senha",senha)
        }
    }
}