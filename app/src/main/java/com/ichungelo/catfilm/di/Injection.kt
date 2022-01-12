package com.ichungelo.catfilm.di

import android.content.Context
import com.ichungelo.catfilm.api.ApiConfig
import com.ichungelo.catfilm.data.source.TmdbRepository
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource
import com.ichungelo.catfilm.utils.DataDummy

object Injection {
    fun provideRepository(): TmdbRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return TmdbRepository.getInstance(remoteDataSource)
    }
}