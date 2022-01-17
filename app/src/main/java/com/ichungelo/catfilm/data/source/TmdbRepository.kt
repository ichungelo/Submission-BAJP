package com.ichungelo.catfilm.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.data.DetailEntity
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource
import com.ichungelo.catfilm.data.source.remote.response.*

class TmdbRepository private constructor(private val remoteDataSource: RemoteDataSource) :
    TmdbDataSource {

    override fun getMovies(): LiveData<List<DataEntity>> {
        val discoverMoviesResult = MutableLiveData<List<DataEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(discoverMovieResponse: List<MovieItems>?) {
                val movieList = ArrayList<DataEntity>()
                if (discoverMovieResponse != null) {
                    for (response in discoverMovieResponse) {
                        with(response) {
                            val movieItems = DataEntity(id, title, posterPath, releaseDate)
                            movieList.add(movieItems)
                        }
                    }
                    discoverMoviesResult.postValue(movieList)
                }
            }
        })
        return discoverMoviesResult
    }

    override fun getSearchMovies(query: String): LiveData<List<DataEntity>> {
        val searchMoviesResult = MutableLiveData<List<DataEntity>>()
        remoteDataSource.getSearchMovies(object : RemoteDataSource.LoadSearchMoviesCallback {
            override fun onSearchMoviesReceived(searchMovieResponse: List<MovieItems>?) {
                val movieList = ArrayList<DataEntity>()
                if (searchMovieResponse != null) {
                    for (response in searchMovieResponse) {
                        with(response) {
                            val movieItems = DataEntity(id, title, posterPath, releaseDate)
                            movieList.add(movieItems)
                        }
                    }
                    searchMoviesResult.postValue(movieList)
                }
            }
        }, query)
        return searchMoviesResult
    }

    override fun getDetailMovie(dataId: String): LiveData<DetailEntity> {
        val detailMovieResult = MutableLiveData<DetailEntity>()
        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback {

            override fun onDetailMovieReceived(detailMovieResponse: DetailMovieResponse?) {
                if (detailMovieResponse != null) {
                    with(detailMovieResponse) {
                        val detailMovieItems = DetailEntity(
                            genres,
                            backdropPath,
                            homepage,
                            id,
                            title,
                            overview,
                            posterPath,
                            tagline,
                            voteAverage,
                            releaseDate
                        )
                        detailMovieResult.postValue(detailMovieItems)
                    }
                }
            }
        }, dataId)
        return detailMovieResult
    }

    override fun getTvShows(): LiveData<List<DataEntity>> {
        val discoverTvShowsResult = MutableLiveData<List<DataEntity>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(discoverTvResponse: List<TvItems>?) {
                val tvShowList = ArrayList<DataEntity>()
                if (discoverTvResponse != null) {
                    for (response in discoverTvResponse) {
                        with(response) {
                            val movieItems = DataEntity(id, title, posterPath, releaseDate)
                            tvShowList.add(movieItems)
                        }
                    }
                    discoverTvShowsResult.postValue(tvShowList)
                }
            }
        })
        return discoverTvShowsResult
    }

    override fun getSearchTvShows(query: String): LiveData<List<DataEntity>> {
        val searchTvShowsResult = MutableLiveData<List<DataEntity>>()
        remoteDataSource.getSearchTvShows(object : RemoteDataSource.LoadSearchTvShowsCallback {
            override fun onSearchTvShowsReceived(searchTvResponse: List<TvItems>?) {
                val tvShowList = ArrayList<DataEntity>()
                if (searchTvResponse != null) {
                    for (response in searchTvResponse) {
                        with(response) {
                            val tvShowItems = DataEntity(id, title, posterPath, releaseDate)
                            tvShowList.add(tvShowItems)
                        }
                    }
                    searchTvShowsResult.postValue(tvShowList)
                }
            }
        }, query)
        return searchTvShowsResult
    }

    override fun getDetailTvShow(dataId: String): LiveData<DetailEntity> {
        val detailTvShowResult = MutableLiveData<DetailEntity>()
        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback {

            override fun onDetailTvShowReceived(detailTvResponse: DetailTvResponse?) {
                if (detailTvResponse != null) {
                    with(detailTvResponse) {
                        val detailTvItems = DetailEntity(
                            genres,
                            backdropPath,
                            homepage,
                            id,
                            title,
                            overview,
                            posterPath,
                            tagline,
                            voteAverage,
                            releaseDate
                        )
                        detailTvShowResult.postValue(detailTvItems)
                    }
                }
            }
        }, dataId)
        return detailTvShowResult
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
