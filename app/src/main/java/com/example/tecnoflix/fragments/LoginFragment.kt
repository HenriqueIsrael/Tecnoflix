package com.example.tecnoflix.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tecnoflix.R
import com.example.tecnoflix.ViewModelFactory
import com.example.tecnoflix.databinding.LoginBinding
import com.example.tecnoflix.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: LoginBinding? = null
    private val binding: LoginBinding get() = _binding!!

    private lateinit var viewModel: LoginViewModel

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

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(LoginViewModel::class.java)

        viewModel.getEmail()

        viewModel.emailLiveData.observe(viewLifecycleOwner, {
            binding.campoEmail.setText(it)
        })

        viewModel.getSenha()

        viewModel.senhaLiveData.observe(viewLifecycleOwner, {
            binding.campoSenha.setText(it)
        })

        binding.switchSalvarLogin.setOnCheckedChangeListener { _ , isChecked ->
            if(isChecked){
                viewModel.saveLogin(binding.campoEmail.text.toString(), binding.campoSenha.text.toString())
            } else {
                viewModel.saveLogin("","")
            }
        }

        binding.btEntrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
        }
    }
}
