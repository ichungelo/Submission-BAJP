package com.ichungelo.catfilm.api

import com.ichungelo.catfilm.data.source.remote.response.DetailMovieResponse
import com.ichungelo.catfilm.data.source.remote.response.DetailTvResponse
import com.ichungelo.catfilm.data.source.remote.response.DiscoverMovieResponse
import com.ichungelo.catfilm.data.source.remote.response.DiscoverTvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getDiscoverMovies(@Query("api_key")api_key: String): Call<DiscoverMovieResponse>

    @GET("discover/tv")
    fun getDiscoverTvShows(@Query("api_key")api_key: String): Call<DiscoverTvResponse>

    @GET("movie/{dataId}")
    fun getDetailMovie(@Path("dataId") dataId: String, @Query("api_key")api_key: String): Call<DetailMovieResponse>

    @GET("tv/{dataId}")
    fun getDetailTvShow(@Path("dataId") dataId: String, @Query("api_key")api_key: String): Call<DetailTvResponse>

    @GET("search/movie")
    fun getSearchMovies(@Query("query") query: String): Call<DiscoverMovieResponse>

    @GET("search/tv")
    fun getSearchTvShows(@Query("query") query: String): Call<DiscoverTvResponse>

}