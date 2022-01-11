package com.ichungelo.catfilm.data.source

import androidx.lifecycle.LiveData
import com.ichungelo.catfilm.data.DetailEntity
import com.ichungelo.catfilm.data.MovieEntity
import com.ichungelo.catfilm.data.TvShowEntity

interface TmdbDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getDetailMovie(dataId: Int): LiveData<DetailEntity>
    fun getTvShows(): LiveData<List<TvShowEntity>>
    fun getDetailTvShow(dataId: Int): LiveData<DetailEntity>
}
