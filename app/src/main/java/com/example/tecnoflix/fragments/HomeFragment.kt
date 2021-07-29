package com.example.tecnoflix.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tecnoflix.adapter.ListaFilmesAdapter
import com.example.tecnoflix.databinding.HomeFragmentBinding

class HomeFragment: Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding: HomeFragmentBinding get() = _binding!!

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

        binding.recyclerViewSeries.adapter = ListaFilmesAdapter()
        binding.recyclerViewEmAlta.adapter = ListaFilmesAdapter()
        binding.recyclerViewAcao.adapter = ListaFilmesAdapter()

    }
}
