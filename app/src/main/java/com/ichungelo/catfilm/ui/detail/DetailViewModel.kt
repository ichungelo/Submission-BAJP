package com.ichungelo.catfilm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.DetailEntity
import com.ichungelo.catfilm.data.source.TmdbRepository

class DetailViewModel(private val tmdbRepository: TmdbRepository) : ViewModel() {
    private lateinit var dataId: String
    private lateinit var dataDetail: LiveData<DetailEntity>

    fun setDataId(dataId: String) {
        this.dataId = dataId
    }

    fun setDetail(from: String?) {
        if(MOVIE == from) {
            dataDetail = tmdbRepository.getDetailMovie(dataId)
        } else if (TV_SHOW == from) {
            dataDetail = tmdbRepository.getDetailTvShow(dataId)
        }
    }

    fun getDetailData() = dataDetail

    companion object {
        const val MOVIE = "movie"
        const val TV_SHOW = "tvShow"
    }
}