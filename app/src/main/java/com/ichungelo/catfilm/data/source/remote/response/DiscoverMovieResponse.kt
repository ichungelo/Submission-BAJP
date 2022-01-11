package com.ichungelo.catfilm.data.source.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

data class DiscoverMovieResponse(
    @field:SerializedName("result")
    var result: List<MovieItems>? = null
)

@Parcelize
data class MovieItems(
    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("original_title")
    var title: String? = null,

    @field:SerializedName("poster_path")
    var posterPath: String? = null,
): Parcelable

data class DetailMovieResponse(
    @field:SerializedName("genres")
    var genres: List<GenreItems>? = null,

    @field:SerializedName("backdrop_path")
    var backdropPath: String? = null,

    @field:SerializedName("homepage")
    var homepage: String? = null,

    @field:SerializedName("id")
    var id: Int? = null,

    @field:SerializedName("original_title")
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
    var releaseDate: Date? = null
)