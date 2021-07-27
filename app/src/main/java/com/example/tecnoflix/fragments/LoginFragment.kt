package com.example.tecnoflix.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.tecnoflix.R
import com.example.tecnoflix.databinding.LoginBinding

class LoginFragment: Fragment() {

    private var _binding: LoginBinding? = null
    private val binding: LoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LoginBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btEntrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
        }
    }
}