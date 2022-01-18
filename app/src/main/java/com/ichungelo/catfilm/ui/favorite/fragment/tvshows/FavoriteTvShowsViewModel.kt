package com.ichungelo.catfilm.ui.favorite.fragment.tvshows

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.TmdbRepository

class FavoriteTvShowsViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getAllTvShowsFavorite() = tmdbRepository.getAllTvShowsFavorite()
    fun getSearchTvShowsFavorite(query: String) = tmdbRepository.getSearchTvShowsFavorite(query)
}