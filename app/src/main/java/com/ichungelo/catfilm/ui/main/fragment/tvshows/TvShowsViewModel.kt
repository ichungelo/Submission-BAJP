package com.ichungelo.catfilm.ui.main.fragment.tvshows

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.source.TmdbRepository

class TvShowsViewModel(private val tmdbRepository: TmdbRepository) : ViewModel() {
    fun getTvShows() = tmdbRepository.getTvShows()
}