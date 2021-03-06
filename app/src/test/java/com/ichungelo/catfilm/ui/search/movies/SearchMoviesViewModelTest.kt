package com.ichungelo.catfilm.ui.search.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SearchMoviesViewModelTest {
    private lateinit var viewModel: SearchMoviesViewModel
    private val dummyMovies = DataDummy.generateDataMovies()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var movieObserver: Observer<List<MovieEntity>>

    @Before
    fun setUp() {
        viewModel = SearchMoviesViewModel(tmdbRepository)
    }
    @Test
    fun getSearchMovies() {
        val favoriteMovies = MutableLiveData<List<MovieEntity>>()
        favoriteMovies.value = dummyMovies

        Mockito.`when`(tmdbRepository.getSearchMovies(DUMMY_INPUT)).thenReturn(favoriteMovies)
        val movieEntities = viewModel.getSearchMovies(DUMMY_INPUT).value as List<MovieEntity>
        Mockito.verify(tmdbRepository).getSearchMovies(DUMMY_INPUT)
        assertNotNull(movieEntities)
        for (index in movieEntities.indices) {
            assertNotNull(movieEntities[index])
            assertNotNull(movieEntities[index].id)
            assertNotNull(movieEntities[index].title)
            assertNotNull(movieEntities[index].posterPath)
            assertEquals(movieEntities[index], dummyMovies[index])
            assertEquals(movieEntities[index].id, dummyMovies[index].id)
            assertEquals(movieEntities[index].title, dummyMovies[index].title)
            assertEquals(movieEntities[index].posterPath, dummyMovies[index].posterPath)
        }
        viewModel.getSearchMovies(DUMMY_INPUT).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovies)
    }

    companion object {
        const val DUMMY_INPUT = ""
    }
}