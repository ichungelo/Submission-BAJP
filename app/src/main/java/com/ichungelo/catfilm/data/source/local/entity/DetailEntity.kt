package com.ichungelo.catfilm.data.source.local.entity

import com.ichungelo.catfilm.data.source.remote.response.GenreItems

data class DetailEntity(
    var genres: List<GenreItems>? = null,
    var backdropPath: String? = null,
    var homepage: String? = null,
    var id: Int? = null,
    var title: String? = null,
    var overview: String? = null,
    var posterPath: String? = null,
    var tagline: String? = null,
    var voteAverage: Double? = null,
    var releaseDate: String? = null
)
