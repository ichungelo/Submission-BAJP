package com.ichungelo.catfilm.data.source.local

import androidx.lifecycle.LiveData
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.data.source.local.room.TmdbDao

class LocalDataSource private constructor(private val tmdbDao: TmdbDao) {
    fun getAllMoviesFavorite(): LiveData<List<MovieEntity>> = tmdbDao.getAllMovies()
    fun getAllTvShowsFavorite(): LiveData<List<TvEntity>> = tmdbDao.getAllTv()
    fun getSearchMoviesFavorite(query: String): LiveData<List<MovieEntity>> = tmdbDao.getDataMovieQuery(query)
    fun getSearchTvShowsFavorite(query: String): LiveData<List<TvEntity>> = tmdbDao.getDataTvQuery(query)
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