package com.ichungelo.catfilm.utils

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ichungelo.catfilm.BuildConfig
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.data.source.remote.response.GenreItems
import java.text.SimpleDateFormat
import java.util.*

object Helper {
    fun changeDateFormat(date: String?): String {
        var result = ""
        if (!date.isNullOrEmpty()) {
            val dateFormatOrigin = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date)
            result =
                SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(dateFormatOrigin!!)
        }
        return result
    }

    fun getReleaseYear(date: String?): String {
        var result = ""
        if (!date.isNullOrEmpty()) {
            val dateFormatOrigin = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date)
            result = SimpleDateFormat("yyyy", Locale.getDefault()).format(dateFormatOrigin!!)
        }
        return result
    }

    fun imageGlider(context: Context, path: String?, view: ImageView) {
        Glide.with(context)
            .load("${BuildConfig.IMAGE_URL}t/p/w500/${path}")
            .apply(
                RequestOptions
                    .placeholderOf(R.drawable.bg_gradient)
                    .error(R.drawable.bg_error)
            )
            .into(view)
    }

    fun setGenreFormat(genre: List<GenreItems>?): String {
        var result = ""
        if (!genre.isNullOrEmpty()) {
            for (i in genre) {
                result += "${i.name}, "
            }
        }
        return result
    }

    fun favoriteAddedToast(context: Context, title: String) {
        Toast.makeText(context,"$title just added to favorite", Toast.LENGTH_SHORT).show()
    }

    fun favoriteRemovedToast(context: Context, title: String) {
        Toast.makeText(context, "$title just removed from favorite", Toast.LENGTH_SHORT).show()
    }
}