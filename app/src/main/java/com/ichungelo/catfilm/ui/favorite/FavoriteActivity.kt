package com.ichungelo.catfilm.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.tabs.TabLayoutMediator
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = FavoritePagerAdapter(this)
        val viewPager2 = binding.favoriteViewPager
        viewPager2.adapter = sectionPagerAdapter
        val tabs = binding.favoriteTabs
        TabLayoutMediator(tabs, viewPager2) { tab, position ->
            tab.setText(TAB_TITLE_FAVORITE[position])
        }.attach()
        supportActionBar?.elevation = 0f

        binding.btnFavoriteBack.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_favorite_back -> onBackPressed()
        }
    }

    companion object {
        private val TAB_TITLE_FAVORITE = intArrayOf(
            R.string.movies,
            R.string.tv_shows
        )
    }
}