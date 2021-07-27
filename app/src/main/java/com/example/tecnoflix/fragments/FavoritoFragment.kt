package com.example.tecnoflix.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnoflix.databinding.FavoritoFragmentBinding

class FavoritoFragment: Fragment() {

    private var _binding: FavoritoFragmentBinding? = null
    private val binding: FavoritoFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FavoritoFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }
}