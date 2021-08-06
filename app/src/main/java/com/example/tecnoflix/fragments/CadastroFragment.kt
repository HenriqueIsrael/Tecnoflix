package com.example.tecnoflix.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.tecnoflix.ViewModelFactory
import com.example.tecnoflix.databinding.CadastroFragmentBinding
import com.example.tecnoflix.viewmodel.CadastroViewModel
import com.example.tecnoflix.viewmodel.HomeViewModel

class CadastroFragment : Fragment() {

    private var _binding: CadastroFragmentBinding? = null
    private val binding: CadastroFragmentBinding get() = _binding!!
    lateinit var viewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CadastroFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(CadastroViewModel::class.java)

        binding.buttonCadastrar.setOnClickListener {
            viewModel.insereUsuario(
                binding.campoEmailCadastro.text.toString(),
                binding.campoSenhaCadastro.text.toString()
            )
            findNavController().navigateUp()
        }

    }
}