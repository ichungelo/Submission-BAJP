package com.ichungelo.catfilm.utils

import androidx.recyclerview.widget.DiffUtil
import com.ichungelo.catfilm.data.DataEntity

class DiffCallback(
    private val mOldDataList: List<DataEntity>,
    private val mNewDataList: List<DataEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return mOldDataList.size
    }

    override fun getNewListSize(): Int {
        return mNewDataList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldDataList[oldItemPosition].id == mNewDataList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldData = mOldDataList[oldItemPosition]
        val newData = mNewDataList[newItemPosition]
        return oldData.id == newData.id &&
                oldData.title == newData.title &&
                oldData.posterPath == newData.posterPath
    }
}