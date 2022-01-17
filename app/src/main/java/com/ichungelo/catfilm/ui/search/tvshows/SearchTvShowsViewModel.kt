package com.ichungelo.catfilm.ui.search.tvshows

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.source.TmdbRepository

class SearchTvShowsViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getSearchTvShows() = tmdbRepository.getSearchTvShows("man")

    companion object {
        const val DATA_QUERY = ""
    }
}