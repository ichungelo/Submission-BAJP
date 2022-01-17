package com.ichungelo.catfilm.api

import com.ichungelo.catfilm.data.source.remote.response.DetailMovieResponse
import com.ichungelo.catfilm.data.source.remote.response.DetailTvResponse
import com.ichungelo.catfilm.data.source.remote.response.AllMovieResponse
import com.ichungelo.catfilm.data.source.remote.response.AllTvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getAllMovies(@Query("api_key")api_key: String): Call<AllMovieResponse>

    @GET("discover/tv")
    fun getAllTvShows(@Query("api_key")api_key: String): Call<AllTvResponse>

    @GET("movie/{dataId}")
    fun getDetailMovie(@Path("dataId") dataId: String, @Query("api_key")api_key: String): Call<DetailMovieResponse>

    @GET("tv/{dataId}")
    fun getDetailTvShow(@Path("dataId") dataId: String, @Query("api_key")api_key: String): Call<DetailTvResponse>

    @GET("search/movie")
    fun getSearchMovies(@Query("query") query: String, @Query("api_key")api_key: String): Call<AllMovieResponse>

    @GET("search/tv")
    fun getSearchTvShows(@Query("query") query: String, @Query("api_key")api_key: String): Call<AllTvResponse>

}