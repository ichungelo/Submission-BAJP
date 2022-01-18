package com.ichungelo.catfilm.ui.favorite.fragment.movies

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.TmdbRepository

class FavoriteMoviesViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getAllMoviesFavorite() = tmdbRepository.getAllMoviesFavorite()
    fun getSearchMoviesFavorite(query: String) = tmdbRepository.getSearchMoviesFavorite(query)
}