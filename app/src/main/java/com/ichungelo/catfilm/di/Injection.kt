package com.ichungelo.catfilm.di

import android.content.Context
import com.ichungelo.catfilm.data.source.TmdbRepository
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): TmdbRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return TmdbRepository.getInstance(remoteDataSource)
    }
}