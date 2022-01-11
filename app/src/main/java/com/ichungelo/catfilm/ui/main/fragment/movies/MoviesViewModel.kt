package com.ichungelo.catfilm.ui.main.fragment.movies

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.data.source.TmdbRepository
import com.ichungelo.catfilm.utils.DataDummy

class MoviesViewModel(private val tmdbRepository: TmdbRepository) : ViewModel() {
    fun getMovies() = tmdbRepository.getMovies()
    fun getTvShows() = tmdbRepository.getTvShows()
}