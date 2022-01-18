package com.ichungelo.catfilm.data.source.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity

@Database(entities = [MovieEntity::class, TvEntity::class], version = 1, exportSchema = false)
abstract class TmdbDatabase : RoomDatabase() {
    abstract fun tmdbDao(): TmdbDao

    companion object {
        @Volatile
        private var INSTANCE: TmdbDatabase? = null

        @JvmStatic
        fun getInstance(context: Context): TmdbDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TmdbDatabase::class.java, "Favorites.db")
                        .build()
                }
            }
            return  INSTANCE as TmdbDatabase
        }
    }
}