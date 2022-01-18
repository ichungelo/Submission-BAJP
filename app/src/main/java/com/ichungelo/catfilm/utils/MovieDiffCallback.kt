package com.ichungelo.catfilm.utils

import androidx.recyclerview.widget.DiffUtil
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity

class MovieDiffCallback(
    private val mOldMovieList: List<MovieEntity>,
    private val mNewMovieList: List<MovieEntity>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return mOldMovieList.size
    }

    override fun getNewListSize(): Int {
        return mNewMovieList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldMovieList[oldItemPosition].id == mNewMovieList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldData = mOldMovieList[oldItemPosition]
        val newData = mNewMovieList[newItemPosition]
        return oldData.id == newData.id &&
                oldData.title == newData.title &&
                oldData.posterPath == newData.posterPath &&
                oldData.releaseDate == newData.releaseDate
    }
}