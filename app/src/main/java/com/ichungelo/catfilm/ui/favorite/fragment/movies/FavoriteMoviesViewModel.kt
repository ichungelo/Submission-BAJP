package com.ichungelo.catfilm.ui.favorite.fragment.movies

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.TmdbRepository

class FavoriteMoviesViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getAllMoviesFavorite(title: String) = tmdbRepository.getAllMoviesFavorite(title)
}