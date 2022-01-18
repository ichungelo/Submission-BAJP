package com.ichungelo.catfilm.ui.search.tvshows

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.TmdbRepository

class SearchTvShowsViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getSearchTvShows(query: String) = tmdbRepository.getSearchTvShows(query)
}