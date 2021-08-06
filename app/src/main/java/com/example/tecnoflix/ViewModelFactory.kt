package com.example.tecnoflix

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tecnoflix.dados.local.database.FavoritoDAO
import com.example.tecnoflix.dados.local.database.FavoritoDatabase
import com.example.tecnoflix.dados.remote.EndPointIMDB
import com.example.tecnoflix.repository.*
import com.example.tecnoflix.viewmodel.*
import java.lang.Exception

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass == LoginViewModel::class.java) {
            return providerLoginViewModel() as T
        } else if (modelClass == HomeViewModel::class.java) {
            return providerHomeViewModel() as T
        } else if (modelClass == BuscarViewModel::class.java) {
            return providerBuscarViewModel() as T
        } else if (modelClass == FavoritoViewModel::class.java) {
            return providerFavoritoViewModel() as T
        } else if (modelClass == ViewPagerViewModel::class.java) {
            return providerViewPagerViewModel() as T
        } else if(modelClass == CadastroViewModel::class.java) {
            return providerCadastroViewModel() as T
        } else {
            throw Exception("Erro ao identificar ViewModel!")
        }
    }

    private fun providerCadastroViewModel(): CadastroViewModel {
        return CadastroViewModel(
            CadastroRepository(
                providerFavoritoDAO(providerFavoritoDatabase())
            )
        )

    }

    private fun providerViewPagerViewModel(): ViewPagerViewModel {
        return ViewPagerViewModel(
            ViewPagerRepository(
                providerEndPointInstance()
            )
        )

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
                ), providerFavoritoDAO(providerFavoritoDatabase())
            )
        )
    }

    private fun providerSharedPreferenceService(preference: SharedPreferences): SharedPreferenceService {
        return SharedPreferenceService(preference)
    }

    private fun providerSharedPreference(): SharedPreferences {
        return context.getSharedPreferences("DATA", Context.MODE_PRIVATE)
    }

    private fun providerFavoritoViewModel(): FavoritoViewModel {
        return FavoritoViewModel(
            FavoritoRepository(
                providerFavoritoDAO(providerFavoritoDatabase())
            )
        )
    }

    private fun providerFavoritoDAO(favoritoDatabase: FavoritoDatabase): FavoritoDAO {
        return favoritoDatabase.favoritoDAO()
    }

    private fun providerFavoritoDatabase(): FavoritoDatabase {
        return FavoritoDatabase.getInstanceDatabase(context)
    }
}
