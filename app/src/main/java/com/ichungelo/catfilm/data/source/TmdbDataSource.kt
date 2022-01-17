package com.ichungelo.catfilm.data.source

import android.app.DownloadManager
import androidx.lifecycle.LiveData
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.data.DetailEntity

interface TmdbDataSource {
    fun getMovies(): LiveData<List<DataEntity>>
    fun getSearchMovies(query: String): LiveData<List<DataEntity>>
    fun getDetailMovie(dataId: String): LiveData<DetailEntity>
    fun getTvShows(): LiveData<List<DataEntity>>
    fun getSearchTvShows(query: String): LiveData<List<DataEntity>>
    fun getDetailTvShow(dataId: String): LiveData<DetailEntity>
}
