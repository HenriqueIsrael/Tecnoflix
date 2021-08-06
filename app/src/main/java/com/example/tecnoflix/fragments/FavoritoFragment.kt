package com.example.tecnoflix.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tecnoflix.ViewModelFactory
import com.example.tecnoflix.activities.InfoActivity
import com.example.tecnoflix.adapter.ListaFavoritosAdapter
import com.example.tecnoflix.adapter.ListaFilmesAdapter
import com.example.tecnoflix.databinding.FavoritoFragmentBinding
import com.example.tecnoflix.viewmodel.FavoritoViewModel
import com.example.tecnoflix.viewmodel.HomeViewModel

class FavoritoFragment: Fragment(), ListaFilmesAdapter.FilmeSelecionado {

    private var _binding: FavoritoFragmentBinding? = null
    private val binding: FavoritoFragmentBinding get() = _binding!!

    lateinit var viewModel: FavoritoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FavoritoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(FavoritoViewModel::class.java)

        viewModel.getListaFilme()

        viewModel.listaFilmesFavoritoLiveData.observe(viewLifecycleOwner,{
            binding.listaFavoritos.adapter = ListaFavoritosAdapter(it,this@FavoritoFragment)
        })
    }

    override fun enviaDadosDoFilmeClikado(
        titulo: String,
        capaFilme: String,
        dataLancamento: String,
        classificacaoFilme: Double,
        numeroVotos: Int,
        sinopse: String
    ) {
        val intent = Intent(requireActivity(), InfoActivity::class.java).apply {
            putExtra("titulo", titulo)
            putExtra("dataLancamento", dataLancamento)
            putExtra("classificacaoFilme", classificacaoFilme)
            putExtra("numeroVotos", numeroVotos)
            putExtra("capaFilme", capaFilme)
            putExtra("sinopse", sinopse)
        }
        startActivity(intent)
    }
}