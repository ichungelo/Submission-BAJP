package com.ichungelo.catfilm.data.source.local

import androidx.appcompat.widget.DialogTitle
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.sqlite.db.SupportSQLiteQuery
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.data.source.local.room.TmdbDao

class LocalDataSource private constructor(private val tmdbDao: TmdbDao) {
    fun getAllMoviesFavorite(query: SupportSQLiteQuery): DataSource.Factory<Int, MovieEntity> = tmdbDao.getAllMovies(query)
    fun getAllTvShowsFavorite(query: SupportSQLiteQuery): DataSource.Factory<Int, TvEntity> = tmdbDao.getAllTv(query)
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