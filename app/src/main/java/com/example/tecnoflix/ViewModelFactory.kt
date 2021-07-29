package com.example.tecnoflix

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnoflix.repository.LoginRepository
import com.example.tecnoflix.viewmodel.LoginViewModel
import java.lang.Exception

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == LoginViewModel::class.java) {
            return providerLoginViewModel() as T
        } else {
            throw Exception("Erro ao identificar ViewModel!")
        }
    }

    private fun providerLoginViewModel(): LoginViewModel {
        return LoginViewModel(
            LoginRepository(
                providerSharedPreferenceService(
                    providerSharedPreference()
                )
            )
        )
    }

    private fun providerSharedPreferenceService(preference: SharedPreferences): SharedPreferenceService {
        return SharedPreferenceService(preference)
    }

    private fun providerSharedPreference(): SharedPreferences {
        return context.getSharedPreferences("DATA", Context.MODE_PRIVATE)
    }
}
