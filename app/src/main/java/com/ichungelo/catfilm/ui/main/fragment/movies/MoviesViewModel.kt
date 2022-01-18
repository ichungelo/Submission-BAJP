package com.ichungelo.catfilm.ui.main.fragment.movies

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.TmdbRepository

class MoviesViewModel(private val tmdbRepository: TmdbRepository) : ViewModel() {
    fun getMovies() = tmdbRepository.getMovies()
}