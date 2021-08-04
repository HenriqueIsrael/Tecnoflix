package com.example.tecnoflix.fragments

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tecnoflix.ViewModelFactory
import com.example.tecnoflix.databinding.PaginaViewPagerBinding
import com.example.tecnoflix.viewmodel.ViewPagerViewModel
import com.squareup.picasso.Picasso

class ViewPagerFragment : Fragment() {

    private var _binding: PaginaViewPagerBinding? = null
    private val binding: PaginaViewPagerBinding get() = _binding!!

    lateinit var viewModel: ViewPagerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = PaginaViewPagerBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(requireContext())
        ).get(ViewPagerViewModel::class.java)

        viewModel.getFilmesCartaz("2021-07-01","2021-08-01")

        viewModel.viewPagerLiveData.observe(viewLifecycleOwner, {
            val posicao = requireArguments().getInt("posicaoViewPager") //Posição do viewpager.
            if (posicao == 0) {
                Picasso.with(binding.imagemViewPager.context)
                    .load("https://image.tmdb.org/t/p/w500/" + it.results[0].backdrop_path)
                    .into(binding.imagemViewPager)
                binding.nomeDoFilmeViewPager.text = it.results[0].title
            } else if (posicao == 1) {
                Picasso.with(binding.imagemViewPager.context)
                    .load("https://image.tmdb.org/t/p/w500/" + it.results[1].backdrop_path)
                    .into(binding.imagemViewPager)
                binding.nomeDoFilmeViewPager.text = it.results[1].title
            } else if (posicao == 2) {
                Picasso.with(binding.imagemViewPager.context)
                    .load("https://image.tmdb.org/t/p/w500/" + it.results[2].backdrop_path)
                    .into(binding.imagemViewPager)
                binding.nomeDoFilmeViewPager.text = it.results[2].title
            } else if (posicao == 3) {
                Picasso.with(binding.imagemViewPager.context)
                    .load("https://image.tmdb.org/t/p/w500/" + it.results[3].backdrop_path)
                    .into(binding.imagemViewPager)
                binding.nomeDoFilmeViewPager.text = it.results[3].title
            }
        })

        viewModel.viewPagerErroLiveData.observe(viewLifecycleOwner, {
            AlertDialog.Builder(requireContext()).setMessage(it).show()
        })
    }
}
