package com.ichungelo.catfilm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    var dataId: String,
    var title: String,
    var year: Int,
    var rating: String,
    var genre: String,
    var tagline: String,
    var overview: String,
    var poster: Int
): Parcelable
