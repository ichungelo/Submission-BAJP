package com.ichungelo.catfilm.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.data.source.local.room.TmdbDao

class LocalDataSource private constructor(private val tmdbDao: TmdbDao) {
    fun getAllMoviesFavorite(): DataSource.Factory<Int, MovieEntity> = tmdbDao.getAllMovies()
    fun getAllTvShowsFavorite(): DataSource.Factory<Int, TvEntity> = tmdbDao.getAllTv()
    fun getSearchMoviesFavorite(query: String): DataSource.Factory<Int, MovieEntity> = tmdbDao.getDataMovieQuery(query)
    fun getSearchTvShowsFavorite(query: String): DataSource.Factory<Int, TvEntity> = tmdbDao.getDataTvQuery(query)
    fun getMovieById(id: String): LiveData<MovieEntity> = tmdbDao.getDataMovieById(id)
    fun getTvById(id: String): LiveData<TvEntity> = tmdbDao.getDataTvById(id)
    fun insertMovieFavorite(movie: MovieEntity) = tmdbDao.insertMovie(movie)
    fun deleteMovieFavorite(movie: MovieEntity) = tmdbDao.deleteMovie(movie)
    fun insertTvFavorite(tvShow: TvEntity) = tmdbDao.insertTv(tvShow)
    fun deleteTvFavorite(tvShow: TvEntity) = tmdbDao.deleteTv(tvShow)

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(tmdbDao: TmdbDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(tmdbDao)
    }
}