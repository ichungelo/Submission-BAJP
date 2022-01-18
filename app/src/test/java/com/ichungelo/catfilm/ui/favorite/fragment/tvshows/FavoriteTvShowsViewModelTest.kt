package com.ichungelo.catfilm.ui.favorite.fragment.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.*

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowsViewModelTest {

    private lateinit var viewModel: FavoriteTvShowsViewModel
    private val dummyTvShows = DataDummy.generateDataTvShows()

    @get:Rule
    var instantTaskExecutorRule =InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var tvShowObserver: Observer<List<TvEntity>>

    @Before
    fun setUp() {
        viewModel = FavoriteTvShowsViewModel(tmdbRepository)
    }

    @Test
    fun getAllTvShowsFavorite() {
        val favoriteTvShows = MutableLiveData<List<TvEntity>>()
        favoriteTvShows.value = dummyTvShows

        Mockito.`when`(tmdbRepository.getAllTvShowsFavorite()).thenReturn(favoriteTvShows)
        val tvEntities = viewModel.getAllTvShowsFavorite().value as List<TvEntity>
        Mockito.verify(tmdbRepository).getAllTvShowsFavorite()
        assertNotNull(tvEntities)
        for (index in tvEntities.indices) {
            assertNotNull(tvEntities[index])
            assertNotNull(tvEntities[index].id)
            assertNotNull(tvEntities[index].title)
            assertNotNull(tvEntities[index].posterPath)
            assertEquals(tvEntities[index], dummyTvShows[index])
            assertEquals(tvEntities[index].id, dummyTvShows[index].id)
            assertEquals(tvEntities[index].title, dummyTvShows[index].title)
            assertEquals(tvEntities[index].posterPath, dummyTvShows[index].posterPath)
        }
        viewModel.getAllTvShowsFavorite().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShows)
    }
}