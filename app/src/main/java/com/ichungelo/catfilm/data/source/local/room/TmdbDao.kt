package com.ichungelo.catfilm.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity

@Dao
interface TmdbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieEntity)

    @Delete
    fun deleteMovie(movie: MovieEntity)

    @Query("SELECT * FROM movie_favorite")
    fun getAllMovies():LiveData<List<MovieEntity>>

    @Query ("SELECT * FROM movie_favorite WHERE  title LIKE :query")
    fun getDataMovieQuery(query: String): LiveData<List<MovieEntity>>

    @Query ("SELECT * FROM movie_favorite WHERE  id LIKE :id")
    fun getDataMovieById(id: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(tvShow: TvEntity)

    @Delete
    fun deleteTv(tvShow: TvEntity)

    @Query("SELECT * FROM tv_favorite")
    fun getAllTv():LiveData<List<TvEntity>>

    @Query ("SELECT * FROM tv_favorite WHERE  title LIKE :query")
    fun getDataTvQuery(query: String): LiveData<List<TvEntity>>

    @Query ("SELECT * FROM tv_favorite WHERE  id LIKE :id")
    fun getDataTvById(id: String): LiveData<TvEntity>
}