package com.ichungelo.catfilm.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class AllMovieResponse(
    @field:SerializedName("results")
    var results: List<MovieItems>? = null
)

data class MovieItems(
    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("title")
    var title: String? = null,

    @field:SerializedName("poster_path")
    var posterPath: String? = null,

    @field:SerializedName("release_date")
    var releaseDate: String? = null,
)

data class DetailMovieResponse(
    @field:SerializedName("genres")
    var genres: List<GenreItems>? = null,

    @field:SerializedName("backdrop_path")
    var backdropPath: String? = null,

    @field:SerializedName("homepage")
    var homepage: String? = null,

    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("title")
    var title: String? = null,

    @field:SerializedName("overview")
    var overview: String? = null,

    @field:SerializedName("poster_path")
    var posterPath: String? = null,

    @field:SerializedName("tagline")
    var tagline: String? = null,

    @field:SerializedName("vote_average")
    var voteAverage: Double? = null,

    @field:SerializedName("release_date")
    var releaseDate: String? = null
)