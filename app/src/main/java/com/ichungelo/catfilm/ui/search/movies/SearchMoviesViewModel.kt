package com.ichungelo.catfilm.ui.search.movies

import android.app.DownloadManager
import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.source.TmdbRepository

class SearchMoviesViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getSearchMovies(query: String) = tmdbRepository.getSearchMovies(query)
}