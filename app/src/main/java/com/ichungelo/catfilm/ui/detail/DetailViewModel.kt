package com.ichungelo.catfilm.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.DetailEntity
import com.ichungelo.catfilm.data.source.TmdbRepository

class DetailViewModel(private val tmdbRepository: TmdbRepository) : ViewModel() {
    private lateinit var dataId: String

    fun setDataId(dataId: String) {
        this.dataId = dataId
    }

    fun getDetailData(from: String?): LiveData<DetailEntity> {
        return if(MOVIE == from) {
            tmdbRepository.getDetailMovie(dataId)
        } else {
            tmdbRepository.getDetailTvShow(dataId)
        }
    }

    companion object {
        const val MOVIE = "Movies"
        const val TV_SHOW = "Tv Shows"
    }
}