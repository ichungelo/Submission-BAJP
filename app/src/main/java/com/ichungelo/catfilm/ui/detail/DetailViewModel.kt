package com.ichungelo.catfilm.ui.detail

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity

class DetailViewModel(private val tmdbRepository: TmdbRepository) : ViewModel() {
    fun getDetailMovie(movieId: String) = tmdbRepository.getDetailMovie(movieId)

    fun getDetailTvShow(tvId: String) = tmdbRepository.getDetailTvShow(tvId)

    fun getMovieById(id: String) = tmdbRepository.getMovieById(id)

    fun insertMovieFavorite(movie: MovieEntity) = tmdbRepository.insertMovieFavorite(movie)

    fun deleteMovieFavorite(movie: MovieEntity) = tmdbRepository.deleteMovieFavorite(movie)

    fun getTvById(id: String) = tmdbRepository.getTvById(id)

    fun insertTvFavorite(tvShow: TvEntity) = tmdbRepository.insertTvFavorite(tvShow)

    fun deleteTvFavorite(tvShow: TvEntity) = tmdbRepository.deleteTvFavorite(tvShow)
}