package com.example.tecnoflix.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tecnoflix.R
import com.example.tecnoflix.databinding.ActivityInfoBinding
import com.example.tecnoflix.databinding.InfoFilmeBinding

class InfoActivity : AppCompatActivity() {

    private var _binding: ActivityInfoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(_binding!!.root)
    }
}
