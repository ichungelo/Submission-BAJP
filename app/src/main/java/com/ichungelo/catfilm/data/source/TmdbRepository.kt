package com.ichungelo.catfilm.data.source

import androidx.lifecycle.LiveData
import com.ichungelo.catfilm.data.DetailEntity
import com.ichungelo.catfilm.data.MovieEntity
import com.ichungelo.catfilm.data.TvShowEntity
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource

class TmdbRepository private constructor(private val remoteDataSource: RemoteDataSource) : TmdbDataSource {

    override fun getMovies(): LiveData<List<MovieEntity>> {
        TODO("Not yet implemented")
    }

    override fun getDetailMovie(dataId: Int): LiveData<DetailEntity> {
        TODO("Not yet implemented")
    }

    override fun getTvShows(): LiveData<List<TvShowEntity>> {
        TODO("Not yet implemented")
    }

    override fun getDetailTvShow(dataId: Int): LiveData<DetailEntity> {
        TODO("Not yet implemented")
    }

    companion object {
        @Volatile
        private var instance: TmdbRepository? = null
        fun getInstance(remoteData: RemoteDataSource): TmdbRepository =
            instance ?: synchronized(this) {
                instance ?: TmdbRepository(remoteData).apply { instance = this }
            }
    }
}
