package com.example.tecnoflix.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
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

        viewModel.switchDefaultTrue()

        viewModel.switchDefaultTrueLiveData.observe(viewLifecycleOwner, {
            if (it) {
                binding.switchSalvarLogin.toggle()
            }
        })

        viewModel.getEmail()

        viewModel.emailLiveData.observe(viewLifecycleOwner, {
            binding.campoEmail.setText(it)
        })

        viewModel.getSenha()

        viewModel.senhaLiveData.observe(viewLifecycleOwner, {
            binding.campoSenha.setText(it)
        })

        binding.switchSalvarLogin.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                viewModel.saveLogin(
                    binding.campoEmail.text.toString(),
                    binding.campoSenha.text.toString()
                )
            } else {
                viewModel.deleteLogin()
            }
        }

        binding.btEntrar.setOnClickListener {
            viewModel.buscaUsuarios(binding.campoEmail.text.toString())
        }
        viewModel.usuarioLiveData.observe(viewLifecycleOwner, {
            if (binding.campoEmail.text.toString() == it.email && binding.campoSenha.text.toString() == it.senha) {
                findNavController().navigate(R.id.action_loginFragment_to_homeActivity)
            } else {
                AlertDialog.Builder(requireContext()).setMessage("Credenciais inválidas!").show()
            }
        })
        binding.cadastrar.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
        }
    }
}
