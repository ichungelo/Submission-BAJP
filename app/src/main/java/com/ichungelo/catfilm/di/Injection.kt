package com.ichungelo.catfilm.di

import android.content.Context
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.data.source.local.LocalDataSource
import com.ichungelo.catfilm.data.source.local.room.TmdbDatabase
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): TmdbRepository {
        val database = TmdbDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.tmdbDao())
        return TmdbRepository.getInstance(remoteDataSource, localDataSource)
    }
}