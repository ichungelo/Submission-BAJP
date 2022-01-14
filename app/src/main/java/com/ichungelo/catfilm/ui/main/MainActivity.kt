package com.ichungelo.catfilm.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.ichungelo.catfilm.ui.favorite.FavoriteActivity
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityMainBinding
import com.ichungelo.catfilm.ui.search.SearchActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
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

        with(binding) {
            btnSearch.setOnClickListener(this@MainActivity)
            btnFavorite.setOnClickListener(this@MainActivity)
        }
    }

    companion object {
        private val TAB_TITLE = intArrayOf(
            R.string.movies,
            R.string.tv_shows
        )
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_search -> {
                val searchActivityIntent = Intent(this, SearchActivity::class.java)
                startActivity(searchActivityIntent)
            }
            R.id.btn_favorite -> {
                val favoriteActivityIntent = Intent(this, FavoriteActivity::class.java)
                startActivity(favoriteActivityIntent)
            }
        }
    }
}