package com.ichungelo.catfilm.ui.main.fragment.tvshows

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.TmdbRepository

class TvShowsViewModel(private val tmdbRepository: TmdbRepository) : ViewModel() {
    fun getTvShows() = tmdbRepository.getTvShows()
}