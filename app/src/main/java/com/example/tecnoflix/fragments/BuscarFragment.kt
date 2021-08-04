package com.example.tecnoflix.fragments

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tecnoflix.ViewModelFactory
import com.example.tecnoflix.activities.InfoActivity
import com.example.tecnoflix.adapter.ListaFilmesAdapter
import com.example.tecnoflix.adapter.SearchFilmsAdapter
import com.example.tecnoflix.databinding.BuscarFragmentBinding
import com.example.tecnoflix.viewmodel.BuscarViewModel
import com.example.tecnoflix.viewmodel.HomeViewModel

class BuscarFragment : Fragment(), ListaFilmesAdapter.FilmeSelecionado {

    private var _binding: BuscarFragmentBinding? = null
    private val binding: BuscarFragmentBinding get() = _binding!!
    lateinit var viewModel: BuscarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = BuscarFragmentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(BuscarViewModel::class.java)

        binding.btBuscar.setOnClickListener {
            viewModel.pesquisaFilme(binding.editTextBuscar.text.toString())
        }
        viewModel.listaPesquisadaLiveData.observe(viewLifecycleOwner, {
            binding.listaTitulos.adapter = SearchFilmsAdapter(it, this@BuscarFragment)
        })

        viewModel.erroLiveData.observe(viewLifecycleOwner, {
            AlertDialog.Builder(requireContext()).setMessage("Deu ruim").show()
        })
    }

    override fun enviaDadosDoFilmeClikado(
        titulo: String,
        capaFilme: String,
        dataLancamento: String,
        classificacaoFilme: Double,
        numeroVotos: Int,
        sinopse: String
    ) {
        val intent = Intent(requireActivity(), InfoActivity::class.java).apply {
            putExtra("titulo", titulo)
            putExtra("dataLancamento", dataLancamento)
            putExtra("classificacaoFilme", classificacaoFilme)
            putExtra("numeroVotos", numeroVotos)
            putExtra("capaFilme", capaFilme)
            putExtra("sinopse", sinopse)
        }
        startActivity(intent)
    }
}