package com.ichungelo.catfilm.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ichungelo.catfilm.ui.favorite.fragment.movies.FavoriteMoviesFragment
import com.ichungelo.catfilm.ui.favorite.fragment.tvshows.FavoriteTvShowsFragment

class FavoritePagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = FavoriteMoviesFragment()
            1 -> fragment = FavoriteTvShowsFragment()
        }
        return fragment as Fragment
    }
}