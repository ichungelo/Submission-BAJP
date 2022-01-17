package com.ichungelo.catfilm.utils

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ichungelo.catfilm.BuildConfig
import com.ichungelo.catfilm.R
import java.text.SimpleDateFormat
import java.util.*

object Helper {
    fun changeDateFormat(date: String?): String {
        var result = ""
        if (date != null) {
            val dateFormatOrigin = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date)
            result = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(dateFormatOrigin!!)
        }
        return result
    }

    fun getReleaseYear(date: String?): String {
        var result = ""
        if (date != null) {
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
                    .error(R.drawable.bg_error))
            .into(view)
    }}