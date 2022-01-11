package com.ichungelo.catfilm.data.source.remote

import android.util.Log
import com.ichungelo.catfilm.BuildConfig.*
import com.ichungelo.catfilm.api.ApiConfig
import com.ichungelo.catfilm.data.source.remote.response.*
import com.ichungelo.catfilm.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    fun getAllMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDiscoverMovies(API_KEY)
        client.enqueue(object : Callback<DiscoverMovieResponse> {
            override fun onResponse(
                call: Call<DiscoverMovieResponse>,
                response: Response<DiscoverMovieResponse>
            ) {
                callback.onAllMoviesReceived(response.body()?.result)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DiscoverMovieResponse>, t: Throwable) {
                Log.e(TAG, "getAllMovies onFailure : ${t.message}")
            }
        })
    }

    fun getDetailMovie(callback: LoadDetailMovieCallback, dataId: Int) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailMovie(dataId, API_KEY)
        client.enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                callback.onDetailMovieReceived(response.body())
                callback.onGenresReceived(response.body()?.genres)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e(TAG, "getDetailMovie onFailure : ${t.message}")
            }

        })
    }

    fun getAllTvShows(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDiscoverTvShows(API_KEY)
        client.enqueue(object : Callback<DiscoverTvResponse> {
            override fun onResponse(
                call: Call<DiscoverTvResponse>,
                response: Response<DiscoverTvResponse>
            ) {
                callback.onAllTvShowsReceived(response.body()?.result)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DiscoverTvResponse>, t: Throwable) {
                Log.e(TAG, "getAllTvShows onFailure : ${t.message}")
            }
        })
    }

    fun getDetailTvShow(callback: LoadDetailTvShowCallback, dataId: Int) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailTvShow(dataId, API_KEY)
        client.enqueue(object : Callback<DetailTvResponse> {
            override fun onResponse(
                call: Call<DetailTvResponse>,
                response: Response<DetailTvResponse>
            ) {
                callback.onDetailTvShowReceived(response.body())
                callback.onGenresReceived(response.body()?.genres)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailTvResponse>, t: Throwable) {
                Log.e(TAG, "getDetailMovie onFailure : ${t.message}")
            }
        })
    }


    interface LoadMoviesCallback {
        fun onAllMoviesReceived(discoverMovieResponse: List<MovieItems>?)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(detailMovieResponse: DetailMovieResponse?)
        fun onGenresReceived(genreItems: List<GenreItems>?)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowsReceived(discoverTvResponse: List<TvItems>?)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(detailTvResponse: DetailTvResponse?)
        fun onGenresReceived(genreItems: List<GenreItems>?)

    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }

        val TAG: String = RemoteDataSource::class.java.simpleName
    }
}