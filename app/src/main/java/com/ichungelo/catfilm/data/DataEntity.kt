package com.ichungelo.catfilm.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataEntity(
    var id: Int? = null,
    var title: String? = null,
    var posterPath: String? = null,
): Parcelable
