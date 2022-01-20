package com.ichungelo.catfilm.ui.favorite.fragment.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMoviesViewModelTest {

    private lateinit var viewModel: FavoriteMoviesViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var movieObserver: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteMoviesViewModel(tmdbRepository)
    }
    @Test
    fun getAllMoviesFavorite() {
        val dummy = pagedList
        `when`(dummy.size).thenReturn(3)
        val favoriteMovies = MutableLiveData<PagedList<MovieEntity>>()
        favoriteMovies.value = dummy

        `when`(tmdbRepository.getAllMoviesFavorite("")).thenReturn(favoriteMovies)
        val movieEntities = viewModel.getAllMoviesFavorite("").value as List<MovieEntity>
        verify(tmdbRepository).getAllMoviesFavorite("")
        assertNotNull(movieEntities)
        assertEquals(3, movieEntities.size)
        viewModel.getAllMoviesFavorite("").observeForever(movieObserver)
        verify(movieObserver).onChanged(dummy)
    }
}