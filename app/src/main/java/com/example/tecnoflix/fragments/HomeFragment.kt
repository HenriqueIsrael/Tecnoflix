package com.example.tecnoflix.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecnoflix.R
import com.example.tecnoflix.ViewModelFactory
import com.example.tecnoflix.activities.InfoActivity
import com.example.tecnoflix.adapter.ListaFilmesAdapter
import com.example.tecnoflix.databinding.HomeFragmentBinding
import com.example.tecnoflix.viewmodel.HomeViewModel
import com.example.tecnoflix.viewmodel.LoginViewModel

class HomeFragment : Fragment(), ListaFilmesAdapter.FilmeSelecionado {

    private var _binding: HomeFragmentBinding? = null
    private val binding: HomeFragmentBinding get() = _binding!!
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(HomeViewModel::class.java)

        binding.recyclerViewSeries.isVisible = false
        binding.recyclerViewEmAlta.isVisible = false
        binding.recyclerViewAcao.isVisible = false

        viewModel.getFilmesPopulares()

        viewModel.listaFilmesLiveData.observe(viewLifecycleOwner, {
            binding.recyclerViewSeries.adapter = ListaFilmesAdapter(it, 1, this@HomeFragment)
            binding.recyclerViewEmAlta.adapter = ListaFilmesAdapter(it, 2, this@HomeFragment)
            binding.recyclerViewAcao.adapter = ListaFilmesAdapter(it, 3, this@HomeFragment)

            binding.recyclerViewSeries.isVisible = true
            binding.recyclerViewEmAlta.isVisible = true
            binding.recyclerViewAcao.isVisible = true
        })

        viewModel.erroLiveData.observe(viewLifecycleOwner, {
            AlertDialog.Builder(requireContext()).setMessage(it).show()
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
        //findNavController().navigate(R.id.action_homeFragment_to_infoActivity)
        val intent = Intent(requireActivity(), InfoActivity::class.java).apply {
            putExtra("titulo",titulo)
            putExtra("dataLancamento",dataLancamento)
            putExtra("classificacaoFilme",classificacaoFilme)
            putExtra("numeroVotos", numeroVotos)
            putExtra("capaFilme",capaFilme)
            putExtra("sinopse",sinopse)
        }
            startActivity(intent)
        }
    }
