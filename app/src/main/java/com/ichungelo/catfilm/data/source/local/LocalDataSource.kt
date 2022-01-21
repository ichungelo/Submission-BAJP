package com.ichungelo.catfilm.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.data.source.local.room.TmdbDao
import com.ichungelo.catfilm.utils.FavoriteSearchUtil

class LocalDataSource private constructor(private val tmdbDao: TmdbDao) {
    fun getAllMoviesFavorite(title: String): DataSource.Factory<Int, MovieEntity> {
        val query = FavoriteSearchUtil.getSearchMoviesQuery(title)
        return tmdbDao.getAllMovies(query)
    }
    fun getAllTvShowsFavorite(title: String): DataSource.Factory<Int, TvEntity>{
        val query = FavoriteSearchUtil.getSearchTvShowQuery(title)
        return tmdbDao.getAllTv(query)
    }
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