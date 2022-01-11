package com.ichungelo.catfilm.ui.main.fragment

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.utils.DataDummy

class DataViewModel : ViewModel() {
    fun getMovies(): List<DataEntity> = DataDummy.generateDataMovies()
    fun getTvShows(): List<DataEntity> = DataDummy.generateDataTvShows()
}