package com.ichungelo.catfilm.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GenreItems(
    @field:SerializedName("name")
    var name: String? = null
)
