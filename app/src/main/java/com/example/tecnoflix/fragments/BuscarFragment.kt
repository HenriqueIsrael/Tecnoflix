package com.example.tecnoflix.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnoflix.databinding.BuscarFragmentBinding

class BuscarFragment: Fragment() {

    private var _binding: BuscarFragmentBinding? = null
    private val binding: BuscarFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BuscarFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }
}