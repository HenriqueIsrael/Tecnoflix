package com.example.tecnoflix.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecnoflix.ViewModelFactory
import com.example.tecnoflix.adapter.ListaFilmesAdapter
import com.example.tecnoflix.databinding.HomeFragmentBinding
import com.example.tecnoflix.viewmodel.HomeViewModel
import com.example.tecnoflix.viewmodel.LoginViewModel

class HomeFragment: Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding: HomeFragmentBinding get() = _binding!!
    private lateinit var viewModel : HomeViewModel

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

        viewModel.getFilmesPopulares()

        viewModel.listaFilmesLiveData.observe(viewLifecycleOwner,{
            AlertDialog.Builder(requireContext()).setMessage("deu certo").show()
        })

        viewModel.erroLiveData.observe(viewLifecycleOwner,{
            AlertDialog.Builder(requireContext()).setMessage(it).show()
        })

        binding.recyclerViewSeries.adapter = ListaFilmesAdapter()
        binding.recyclerViewEmAlta.adapter = ListaFilmesAdapter()
        binding.recyclerViewAcao.adapter = ListaFilmesAdapter()
    }
}
