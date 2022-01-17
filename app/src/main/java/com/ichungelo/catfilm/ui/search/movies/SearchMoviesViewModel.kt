package com.ichungelo.catfilm.ui.search.movies

import android.app.DownloadManager
import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.source.TmdbRepository

class SearchMoviesViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getSearchMovies() = tmdbRepository.getSearchMovies("test")

    companion object {
        const val DATA_QUERY = ""
    }
}