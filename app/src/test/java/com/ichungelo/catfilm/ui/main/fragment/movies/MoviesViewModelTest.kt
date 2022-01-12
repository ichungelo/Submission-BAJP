package com.ichungelo.catfilm.ui.main.fragment.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.data.source.TmdbRepository
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
class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel
    private val dummyAllMovies = DataDummy.generateDataMovies()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var movieObserver: Observer<List<DataEntity>>

    @Before
    fun setUp() {
        viewModel = MoviesViewModel(tmdbRepository)
    }

    @Test
    fun getMovies() {
        val allMovies = MutableLiveData<List<DataEntity>>()
        allMovies.value = dummyAllMovies

        Mockito.`when`(tmdbRepository.getMovies()).thenReturn(allMovies)
        val movieEntities = viewModel.getMovies().value as List<DataEntity>
        Mockito.verify(tmdbRepository).getMovies()
        assertNotNull(movieEntities)
        for (index in movieEntities.indices) {
            assertNotNull(movieEntities[index])
            assertNotNull(movieEntities[index].id)
            assertNotNull(movieEntities[index].title)
            assertNotNull(movieEntities[index].posterPath)
            assertEquals(movieEntities[index], dummyAllMovies[index])
            assertEquals(movieEntities[index].id, dummyAllMovies[index].id)
            assertEquals(movieEntities[index].title, dummyAllMovies[index].title)
            assertEquals(movieEntities[index].posterPath, dummyAllMovies[index].posterPath)
        }

        viewModel.getMovies().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyAllMovies)
    }
}