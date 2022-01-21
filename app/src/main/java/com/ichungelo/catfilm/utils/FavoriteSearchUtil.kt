package com.ichungelo.catfilm.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object FavoriteSearchUtil {
    fun getSearchMoviesQuery(title: String?): SimpleSQLiteQuery {
        val query = StringBuilder().append("SELECT * FROM movie_favorite $title")
        return SimpleSQLiteQuery(query.toString())
    }

    fun getSearchTvShowQuery(title: String?): SimpleSQLiteQuery {
        val query = StringBuilder().append("SELECT * FROM tv_favorite $title")
        return SimpleSQLiteQuery(query.toString())
    }
}