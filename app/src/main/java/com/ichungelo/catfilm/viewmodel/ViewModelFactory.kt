package com.ichungelo.catfilm.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.di.Injection
import com.ichungelo.catfilm.ui.detail.DetailViewModel
import com.ichungelo.catfilm.ui.favorite.fragment.movies.FavoriteMoviesViewModel
import com.ichungelo.catfilm.ui.favorite.fragment.tvshows.FavoriteTvShowsViewModel
import com.ichungelo.catfilm.ui.main.fragment.movies.MoviesViewModel
import com.ichungelo.catfilm.ui.main.fragment.tvshows.TvShowsViewModel
import com.ichungelo.catfilm.ui.search.movies.SearchMoviesViewModel
import com.ichungelo.catfilm.ui.search.tvshows.SearchTvShowsViewModel

class ViewModelFactory private constructor(private val tmdbRepository: TmdbRepository) :
    ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(TvShowsViewModel::class.java) -> {
                TvShowsViewModel(tmdbRepository) as T
            }
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                MoviesViewModel(tmdbRepository) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(tmdbRepository) as T
            }
            modelClass.isAssignableFrom(SearchMoviesViewModel::class.java) -> {
                SearchMoviesViewModel(tmdbRepository) as T
            }
            modelClass.isAssignableFrom(SearchTvShowsViewModel::class.java) -> {
                SearchTvShowsViewModel(tmdbRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java) -> {
                FavoriteMoviesViewModel(tmdbRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowsViewModel::class.java) -> {
                FavoriteTvShowsViewModel(tmdbRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }
}
