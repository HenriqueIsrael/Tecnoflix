package com.example.tecnoflix.fragments

import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnoflix.databinding.InfoFilmeBinding
import com.squareup.picasso.Picasso


class InfoFilmeFragment: Fragment() {

    private var _binding: InfoFilmeBinding? = null
    private val binding: InfoFilmeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = InfoFilmeBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val intent = requireActivity().intent

        Picasso.with(binding.capa.context).load(intent.getStringExtra("capaFilme")).into(binding.capa)

        binding.titulo.text = intent.getStringExtra("titulo")

        binding.dataLancamento.text = binding.dataLancamento.text.toString() + intent.getStringExtra("dataLancamento")

        binding.avaliacao.text = binding.avaliacao.text.toString() + intent.getDoubleExtra("classificacaoFilme",0.00).toString()

        binding.votos.text = binding.votos.text.toString() + intent.getIntExtra("numeroVotos",0).toString()

        binding.sinopse.text = binding.sinopse.text.toString() + intent.getStringExtra("sinopse")
    }
}
