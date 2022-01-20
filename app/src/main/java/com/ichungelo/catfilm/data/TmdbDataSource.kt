package com.ichungelo.catfilm.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
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
    fun getAllMoviesFavorite(title: String): LiveData<PagedList<MovieEntity>>
    fun getAllTvShowsFavorite(title: String): LiveData<PagedList<TvEntity>>
    fun getMovieById(id: String): LiveData<MovieEntity>
    fun getTvById(id: String): LiveData<TvEntity>
    fun insertMovieFavorite(movie: MovieEntity)
    fun deleteMovieFavorite(movie: MovieEntity)
    fun insertTvFavorite(tvShow: TvEntity)
    fun deleteTvFavorite(tvShow: TvEntity)
}
