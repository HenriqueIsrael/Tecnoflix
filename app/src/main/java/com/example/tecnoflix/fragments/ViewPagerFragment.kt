package com.example.tecnoflix.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tecnoflix.databinding.PaginaViewPagerBinding
import com.example.tecnoflix.databinding.SplashBinding
import com.squareup.picasso.Picasso

class ViewPagerFragment: Fragment() {

    private var _binding: PaginaViewPagerBinding? = null
    private val binding: PaginaViewPagerBinding get() = _binding!!

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
        val posicao = requireArguments().getInt("posicaoViewPager") //Posição do viewpager.

        if (posicao == 0) {
           Picasso.with(binding.imagemViewPager.context)
               .load("https://legadoplus.com.br/wp-content/uploads/2021/06/Velozes-e-Furiosos-9-dublado-Assista-ao-novo-filme-da-saga-no-Brasil-Legado-Plus.jpg")
              .into(binding.imagemViewPager)
        } else if (posicao == 1){
            Picasso.with(binding.imagemViewPager.context)
                .load("https://taverna42.files.wordpress.com/2016/12/rogue_one_wallpaper__theatrical_poster__by_spirit__of_adventure-dam3ha4.jpg")
                .into(binding.imagemViewPager)
        } else if(posicao ==2){
            Picasso.with(binding.imagemViewPager.context)
                .load("https://www.jornalbomdia.com.br/tb_noticias/33961/Cartaz-Minha-Ma%CC%83e-E%CC%81-Uma-Pec%CC%A7a-3-1-e1568836287190-750x380.jpg")
                .into(binding.imagemViewPager)
        } else if(posicao==3){
            Picasso.with(binding.imagemViewPager.context)
                .load("https://images8.alphacoders.com/378/thumb-1920-378546.jpg")
                .into(binding.imagemViewPager)
        }
    }
}
