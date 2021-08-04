package com.example.tecnoflix.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tecnoflix.R
import com.example.tecnoflix.ViewModelFactory
import com.example.tecnoflix.databinding.InfoFilmeBinding
import com.example.tecnoflix.viewmodel.FavoritoViewModel
import com.squareup.picasso.Picasso


class InfoFilmeFragment : Fragment() {

    private var _binding: InfoFilmeBinding? = null
    private val binding: InfoFilmeBinding get() = _binding!!

    private var favorito: Boolean = false

    lateinit var viewModel: FavoritoViewModel

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

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(FavoritoViewModel::class.java)

        val intent = requireActivity().intent

        viewModel.buscaFilme(intent.getStringExtra("titulo")!!)
        viewModel.buscaFilmesFavoritoLiveData.observe(viewLifecycleOwner,{
            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })

        colocaDadosFilmeTela()

        binding.toolbar3.setNavigationOnClickListener {
            requireActivity().finish()
        }

        binding.btFavorito.setOnClickListener {
            viewModel.cliqueNoBotaoFavorito()
        }

        viewModel.coracaoColorido.observe(viewLifecycleOwner, {
            if(it){
                binding.btFavorito.setImageResource(R.drawable.ic_favoritar)
            }else{
                binding.btFavorito.setImageResource(R.drawable.ic_nao_favorito)
            }
        })

        viewModel.controleSalvaOuDeleta.observe(viewLifecycleOwner, {
            if(it){
                viewModel.enviaFilme(
                    intent.getStringExtra("titulo")!!,
                    intent.getStringExtra("capaFilme")!!
                )
            }else{
                viewModel.deletaFilme(
                    intent.getStringExtra("titulo")!!
                )
            }
        })
    }

    private fun colocaDadosFilmeTela() {
        val intent = requireActivity().intent

        Picasso.with(binding.capa.context).load(intent.getStringExtra("capaFilme"))
            .into(binding.capa)

        binding.titulo.text = intent.getStringExtra("titulo")

        binding.dataLancamento.text =
            binding.dataLancamento.text.toString() + intent.getStringExtra("dataLancamento")

        binding.avaliacao.text =
            binding.avaliacao.text.toString() + intent.getDoubleExtra("classificacaoFilme", 0.00)
                .toString()

        binding.votos.text =
            binding.votos.text.toString() + intent.getIntExtra("numeroVotos", 0).toString()

        binding.sinopse.text = binding.sinopse.text.toString() + intent.getStringExtra("sinopse")
    }
}
