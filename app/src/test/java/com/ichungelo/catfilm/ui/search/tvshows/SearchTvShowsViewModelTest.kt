package com.ichungelo.catfilm.ui.search.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
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
class SearchTvShowsViewModelTest {
    private lateinit var viewModel: SearchTvShowsViewModel
    private val dummyTvShows = DataDummy.generateDataTvShows()

    @get:Rule
    var instantTaskExecutorRule =InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var tvShowObserver: Observer<List<TvEntity>>

    @Before
    fun setUp() {
        viewModel = SearchTvShowsViewModel(tmdbRepository)
    }
    @Test
    fun getSearchTvShows() {
        val favoriteTvShows = MutableLiveData<List<TvEntity>>()
        val query = "TEST"
        favoriteTvShows.value = dummyTvShows

        Mockito.`when`(tmdbRepository.getSearchTvShows(query)).thenReturn(favoriteTvShows)
        val tvEntities = viewModel.getSearchTvShows(query).value as List<TvEntity>
        Mockito.verify(tmdbRepository).getSearchTvShows(query)
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
        viewModel.getSearchTvShows(query).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShows)
    }
}