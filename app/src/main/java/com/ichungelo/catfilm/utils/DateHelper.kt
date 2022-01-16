package com.ichungelo.catfilm.utils

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {
    fun changeDateFormat(date: String?): String {
        var result = ""
        if (date != null) {
            val dateFormatOrigin = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date)
            result = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(dateFormatOrigin!!)
        }
        return result
    }
}