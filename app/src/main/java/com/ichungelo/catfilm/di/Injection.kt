package com.ichungelo.catfilm.di

import com.ichungelo.catfilm.data.source.TmdbRepository
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): TmdbRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return TmdbRepository.getInstance(remoteDataSource)
    }
}