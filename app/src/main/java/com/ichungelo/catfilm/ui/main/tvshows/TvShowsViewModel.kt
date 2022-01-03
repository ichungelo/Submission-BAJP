package com.ichungelo.catfilm.ui.main.tvshows

import androidx.lifecycle.ViewModel
import com.ichungelo.catfilm.model.DataEntity
import com.ichungelo.catfilm.utils.Data

class TvShowsViewModel: ViewModel() {
    fun getTvShows(): List<DataEntity> = Data.generateDataTvShows()
}