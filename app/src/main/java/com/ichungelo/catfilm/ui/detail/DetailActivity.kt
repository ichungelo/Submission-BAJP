package com.ichungelo.catfilm.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ichungelo.catfilm.databinding.ActivityDetailBinding
import com.ichungelo.catfilm.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}