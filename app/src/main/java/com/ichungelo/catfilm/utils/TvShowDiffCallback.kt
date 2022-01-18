package com.ichungelo.catfilm.utils

import androidx.recyclerview.widget.DiffUtil
import com.ichungelo.catfilm.data.source.local.entity.TvEntity

class TvShowDiffCallback(
    private val mOldTvList: List<TvEntity>,
    private val mNewTvList: List<TvEntity>,
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return mOldTvList.size
    }

    override fun getNewListSize(): Int {
        return mNewTvList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldTvList[oldItemPosition].id == mNewTvList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldData = mOldTvList[oldItemPosition]
        val newData = mNewTvList[newItemPosition]
        return oldData.id == newData.id &&
                oldData.title == newData.title &&
                oldData.posterPath == newData.posterPath &&
                oldData.releaseDate == newData.releaseDate
    }
}