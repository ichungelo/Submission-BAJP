package com.ichungelo.catfilm.ui.favorite.fragment.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity

class FavoriteMoviesViewModel(private val tmdbRepository: TmdbRepository): ViewModel() {
    fun getAllMoviesFavorite(): LiveData<PagedList<MovieEntity>> = tmdbRepository.getAllMoviesFavorite()
    fun getSearchMoviesFavorite(query: String) = tmdbRepository.getSearchMoviesFavorite(query)
}