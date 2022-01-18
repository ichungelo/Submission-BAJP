package com.ichungelo.catfilm.data

import androidx.lifecycle.LiveData
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.DetailEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity

interface TmdbDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getSearchMovies(query: String): LiveData<List<MovieEntity>>
    fun getDetailMovie(dataId: String): LiveData<DetailEntity>
    fun getTvShows(): LiveData<List<TvEntity>>
    fun getSearchTvShows(query: String): LiveData<List<TvEntity>>
    fun getDetailTvShow(dataId: String): LiveData<DetailEntity>
    fun getAllMoviesFavorite(): LiveData<List<MovieEntity>>
    fun getAllTvShowsFavorite(): LiveData<List<TvEntity>>
    fun getSearchMoviesFavorite(query: String): LiveData<List<MovieEntity>>
    fun getSearchTvShowsFavorite(query: String): LiveData<List<TvEntity>>
    fun getMovieById(id: String): LiveData<MovieEntity>
    fun getTvById(id: String): LiveData<TvEntity>
    fun insertMovieFavorite(movie: MovieEntity)
    fun deleteMovieFavorite(movie: MovieEntity)
    fun insertTvFavorite(tvShow: TvEntity)
    fun deleteTvFavorite(tvShow: TvEntity)
}
