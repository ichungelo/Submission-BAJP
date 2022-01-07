package com.ichungelo.catfilm.ui.main.fragment

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.model.DataEntity
import com.ichungelo.catfilm.utils.Data

class DataViewModel : ViewModel() {
    fun getMovies(): List<DataEntity> = Data.generateDataMovies()
    fun getTvShows(): List<DataEntity> = Data.generateDataTvShows()
}