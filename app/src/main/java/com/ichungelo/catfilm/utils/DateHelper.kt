package com.ichungelo.catfilm.utils

import java.text.SimpleDateFormat
import java.util.*

object DateHelper {
    fun changeDateFormat(date: String): String {
        val dateFormatOrigin = SimpleDateFormat("dd MMMM, yyyy (HH:mm:ss)", Locale.getDefault()).parse(date)
        return SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(dateFormatOrigin!!)
    }
}