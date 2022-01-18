package com.ichungelo.catfilm.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ichungelo.catfilm.data.TmdbDataSource
import com.ichungelo.catfilm.data.source.local.LocalDataSource
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.DetailEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource
import com.ichungelo.catfilm.data.source.remote.response.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeTmdbRepository constructor(
private val remoteDataSource: RemoteDataSource,
private val localDataSource: LocalDataSource,
) : TmdbDataSource {
    override fun getMovies(): LiveData<List<MovieEntity>> {
        val discoverMoviesResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getAllMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onAllMoviesReceived(discoverMovieResponse: List<MovieItems>?) {
                val movieList = ArrayList<MovieEntity>()
                if (discoverMovieResponse != null) {
                    for (response in discoverMovieResponse) {
                        with(response) {
                            val movieItems = MovieEntity(id, title, posterPath, releaseDate)
                            movieList.add(movieItems)
                        }
                    }
                    discoverMoviesResult.postValue(movieList)
                }
            }
        })
        return discoverMoviesResult
    }

    override fun getSearchMovies(query: String): LiveData<List<MovieEntity>> {
        val searchMoviesResult = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getSearchMovies(object : RemoteDataSource.LoadSearchMoviesCallback {
            override fun onSearchMoviesReceived(searchMovieResponse: List<MovieItems>?) {
                val movieList = ArrayList<MovieEntity>()
                if (searchMovieResponse != null) {
                    for (response in searchMovieResponse) {
                        with(response) {
                            val movieItems = MovieEntity(id, title, posterPath, releaseDate)
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

    override fun getTvShows(): LiveData<List<TvEntity>> {
        val discoverTvShowsResult = MutableLiveData<List<TvEntity>>()
        remoteDataSource.getAllTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onAllTvShowsReceived(discoverTvResponse: List<TvItems>?) {
                val tvShowList = ArrayList<TvEntity>()
                if (discoverTvResponse != null) {
                    for (response in discoverTvResponse) {
                        with(response) {
                            val tvShowItems = TvEntity(id, title, posterPath, releaseDate)
                            tvShowList.add(tvShowItems)
                        }
                    }
                    discoverTvShowsResult.postValue(tvShowList)
                }
            }
        })
        return discoverTvShowsResult
    }

    override fun getSearchTvShows(query: String): LiveData<List<TvEntity>> {
        val searchTvShowsResult = MutableLiveData<List<TvEntity>>()
        remoteDataSource.getSearchTvShows(object : RemoteDataSource.LoadSearchTvShowsCallback {
            override fun onSearchTvShowsReceived(searchTvResponse: List<TvItems>?) {
                val tvShowList = ArrayList<TvEntity>()
                if (searchTvResponse != null) {
                    for (response in searchTvResponse) {
                        with(response) {
                            val tvShowItems = TvEntity(id, title, posterPath, releaseDate)
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

    override fun getAllMoviesFavorite(): LiveData<List<MovieEntity>> =
        localDataSource.getAllMoviesFavorite()

    override fun getAllTvShowsFavorite(): LiveData<List<TvEntity>> =
        localDataSource.getAllTvShowsFavorite()

    override fun getSearchMoviesFavorite(query: String): LiveData<List<MovieEntity>> =
        localDataSource.getSearchMoviesFavorite(query)

    override fun getSearchTvShowsFavorite(query: String): LiveData<List<TvEntity>> =
        localDataSource.getSearchTvShowsFavorite(query)

    override fun getMovieById(id: String): LiveData<MovieEntity> = localDataSource.getMovieById(id)

    override fun getTvById(id: String): LiveData<TvEntity> =localDataSource.getTvById(id)

    override fun insertMovieFavorite(movie: MovieEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.insertMovieFavorite(movie)
        }
    }

    override fun deleteMovieFavorite(movie: MovieEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.deleteMovieFavorite(movie)
        }
    }

    override fun insertTvFavorite(tvShow: TvEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.insertTvFavorite(tvShow)
        }
    }

    override fun deleteTvFavorite(tvShow: TvEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            localDataSource.deleteTvFavorite(tvShow)
        }
    }
}
