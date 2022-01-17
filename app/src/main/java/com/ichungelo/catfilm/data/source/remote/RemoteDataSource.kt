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
        val client = ApiConfig.getApiService().getAllMovies(API_KEY)
        client.enqueue(object : Callback<AllMovieResponse> {
            override fun onResponse(
                call: Call<AllMovieResponse>,
                response: Response<AllMovieResponse>
            ) {
                callback.onAllMoviesReceived(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<AllMovieResponse>, t: Throwable) {
                Log.e(TAG, "getAllMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getSearchMovies(callback: LoadSearchMoviesCallback, query: String) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getSearchMovies(query ,API_KEY)
        client.enqueue(object : Callback<AllMovieResponse> {
            override fun onResponse(
                call: Call<AllMovieResponse>,
                response: Response<AllMovieResponse>
            ) {
                callback.onSearchMoviesReceived(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<AllMovieResponse>, t: Throwable) {
                Log.e(TAG, "getSearchMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getDetailMovie(callback: LoadDetailMovieCallback, dataId: String) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailMovie(dataId, API_KEY)
        client.enqueue(object : Callback<DetailMovieResponse> {
            override fun onResponse(
                call: Call<DetailMovieResponse>,
                response: Response<DetailMovieResponse>
            ) {
                callback.onDetailMovieReceived(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                Log.e(TAG, "getDetailMovie onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }

        })
    }

    fun getAllTvShows(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getAllTvShows(API_KEY)
        client.enqueue(object : Callback<AllTvResponse> {
            override fun onResponse(
                call: Call<AllTvResponse>,
                response: Response<AllTvResponse>
            ) {
                callback.onAllTvShowsReceived(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<AllTvResponse>, t: Throwable) {
                Log.e(TAG, "getAllTvShows onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getSearchTvShows(callback: LoadSearchTvShowsCallback, query: String) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getSearchTvShows(query ,API_KEY)
        client.enqueue(object : Callback<AllTvResponse> {
            override fun onResponse(
                call: Call<AllTvResponse>,
                response: Response<AllTvResponse>
            ) {
                callback.onSearchTvShowsReceived(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<AllTvResponse>, t: Throwable) {
                Log.e(TAG, "getSearchTvShows onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getDetailTvShow(callback: LoadDetailTvShowCallback, dataId: String) {
        EspressoIdlingResource.increment()
        val client = ApiConfig.getApiService().getDetailTvShow(dataId, API_KEY)
        client.enqueue(object : Callback<DetailTvResponse> {
            override fun onResponse(
                call: Call<DetailTvResponse>,
                response: Response<DetailTvResponse>
            ) {
                callback.onDetailTvShowReceived(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailTvResponse>, t: Throwable) {
                Log.e(TAG, "getDetailMovie onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }


    interface LoadMoviesCallback {
        fun onAllMoviesReceived(discoverMovieResponse: List<MovieItems>?)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieReceived(detailMovieResponse: DetailMovieResponse?)
    }

    interface LoadTvShowsCallback {
        fun onAllTvShowsReceived(discoverTvResponse: List<TvItems>?)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowReceived(detailTvResponse: DetailTvResponse?)
    }

    interface LoadSearchMoviesCallback {
        fun onSearchMoviesReceived(searchMovieResponse: List<MovieItems>?)
    }

    interface LoadSearchTvShowsCallback {
        fun onSearchTvShowsReceived(searchTvResponse: List<TvItems>?)
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