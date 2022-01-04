package com.ichungelo.catfilm.ui.main.movies

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.model.DataEntity
import com.ichungelo.catfilm.utils.Data

class MoviesViewModel : ViewModel() {
    fun getMovies(): List<DataEntity> = Data.generateDataMovies()
}