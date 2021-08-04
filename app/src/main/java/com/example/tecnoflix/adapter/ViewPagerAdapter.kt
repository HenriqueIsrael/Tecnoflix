package com.example.tecnoflix.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tecnoflix.fragments.ViewPagerFragment

class ViewPagerAdapter(fragmento: Fragment): FragmentStateAdapter(fragmento) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return ViewPagerFragment().also{
            it.arguments = Bundle().apply {
                putInt("posicaoViewPager",position)
            }
        }
    }
}
