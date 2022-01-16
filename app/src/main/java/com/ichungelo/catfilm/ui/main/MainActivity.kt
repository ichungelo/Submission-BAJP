package com.ichungelo.catfilm.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager2 = binding.viewPager
        viewPager2.adapter = sectionPagerAdapter
        val tabs = binding.tabs
        TabLayoutMediator(tabs, viewPager2) { tab, position ->
            tab.setText(TAB_TITLE[position])
        }.attach()
        supportActionBar?.elevation = 0f
    }

    companion object {
        private val TAB_TITLE = intArrayOf(
            R.string.movies,
            R.string.tv_shows
        )
    }
}