package com.ichungelo.catfilm.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ichungelo.catfilm.data.TmdbDataSource
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.DetailEntity
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource
import com.ichungelo.catfilm.data.source.remote.response.*

class FakeTmdbRepository(private val remoteDataSource: RemoteDataSource) : TmdbDataSource {

    override fun getMovies(): LiveData<List<MovieEntity>> {
        val discoverMoviesResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(discoverMovieResponse: List<MovieItems>?) {
                val movieList = ArrayList<MovieEntity>()
                if (discoverMovieResponse != null) {
                    for (response in discoverMovieResponse) {
                        with(response) {
                            val movieItems = MovieEntity(id, title, posterPath)
                            movieList.add(movieItems)
                        }
                    }
                    discoverMoviesResult.postValue(movieList)
                }
            }
        })
        return discoverMoviesResult
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

    override fun getTvShows(): LiveData<List<MovieEntity>> {
        val discoverTvShowsResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(discoverTvResponse: List<TvItems>?) {
                val movieList = ArrayList<MovieEntity>()
                if (discoverTvResponse != null) {
                    for (response in discoverTvResponse) {
                        with(response) {
                            val movieItems = MovieEntity(id, title, posterPath)
                            movieList.add(movieItems)
                        }
                    }
                    discoverTvShowsResult.postValue(movieList)
                }
            }
        })
        return discoverTvShowsResult
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
}