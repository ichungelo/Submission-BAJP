package com.ichungelo.catfilm.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity

@Dao
interface TmdbDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovie(movie: MovieEntity)

    @Delete
    fun deleteMovie(movie: MovieEntity)

    @RawQuery(observedEntities = [MovieEntity::class])
    fun getAllMovies(query: SupportSQLiteQuery):DataSource.Factory<Int, MovieEntity>

    @Query ("SELECT * FROM movie_favorite WHERE  id LIKE :id")
    fun getDataMovieById(id: String): LiveData<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(tvShow: TvEntity)

    @Delete
    fun deleteTv(tvShow: TvEntity)

    @RawQuery(observedEntities = [TvEntity::class])
    fun getAllTv(query: SupportSQLiteQuery):DataSource.Factory<Int, TvEntity>

    @Query ("SELECT * FROM tv_favorite WHERE  id LIKE :id")
    fun getDataTvById(id: String): LiveData<TvEntity>
}