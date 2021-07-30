package com.example.tecnoflix

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnoflix.dados.remote.EndPointIMDB
import com.example.tecnoflix.repository.BuscarRepository
import com.example.tecnoflix.repository.HomeRepository
import com.example.tecnoflix.repository.LoginRepository
import com.example.tecnoflix.viewmodel.BuscarViewModel
import com.example.tecnoflix.viewmodel.HomeViewModel
import com.example.tecnoflix.viewmodel.LoginViewModel
import java.lang.Exception

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == LoginViewModel::class.java) {
            return providerLoginViewModel() as T
        } else if (modelClass == HomeViewModel::class.java) {
            return providerHomeViewModel() as T
        } else if(modelClass == BuscarViewModel::class.java) {
            return providerBuscarViewModel() as T
        } else {
            throw Exception("Erro ao identificar ViewModel!")
        }
    }

    private fun providerBuscarViewModel(): BuscarViewModel {
        return BuscarViewModel(
            BuscarRepository(
                providerEndPointInstance()
            )
        )
    }

    private fun providerHomeViewModel(): HomeViewModel {
        return HomeViewModel(
            HomeRepository(
                providerEndPointInstance()
            )
        )
    }

    private fun providerEndPointInstance(): EndPointIMDB {
        return EndPointIMDB.getEndPointInstance()
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
