package com.ichungelo.catfilm.utils

import androidx.sqlite.db.SimpleSQLiteQuery
import java.lang.StringBuilder

object SearchUtils {
    fun getMoviesQuery(title: String): SimpleSQLiteQuery {
        val query = StringBuilder().append("SELECT * FROM movie_favorite ")

        if (!title.isNullOrEmpty()) {
            query.append("WHERE title LIKE \'%$title%\'")
        }
        return SimpleSQLiteQuery(query.toString())
    }

    fun getTvQuery(title: String): SimpleSQLiteQuery {
        val query = StringBuilder().append("SELECT * FROM tv_favorite ")

        if (!title.isNullOrEmpty()) {
            query.append("WHERE title LIKE \'%$title%\'")
        }
        return SimpleSQLiteQuery(query.toString())
    }
}