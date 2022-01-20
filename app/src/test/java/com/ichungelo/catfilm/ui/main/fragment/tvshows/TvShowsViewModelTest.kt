package com.ichungelo.catfilm.ui.main.fragment.tvshows

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
class TvShowsViewModelTest {
    private lateinit var viewModel: TvShowsViewModel
    private var dummyAllTvShows = DataDummy.generateDataTvShows()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var tvShowObserver: Observer<List<TvEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel(tmdbRepository)
    }

    @Test
    fun getTvShows() {
        val allTvShows = MutableLiveData<List<TvEntity>>()
        allTvShows.value = dummyAllTvShows

        Mockito.`when`(tmdbRepository.getTvShows()).thenReturn(allTvShows)
        val tvShowEntities = viewModel.getTvShows().value as List<TvEntity>
        Mockito.verify(tmdbRepository).getTvShows()
        assertNotNull(tvShowEntities)
        for (index in tvShowEntities.indices) {
            assertNotNull(tvShowEntities[index])
            assertNotNull(tvShowEntities[index].id)
            assertNotNull(tvShowEntities[index].title)
            assertNotNull(tvShowEntities[index].posterPath)
            assertEquals(tvShowEntities[index], dummyAllTvShows[index])
            assertEquals(tvShowEntities[index].id, dummyAllTvShows[index].id)
            assertEquals(tvShowEntities[index].title, dummyAllTvShows[index].title)
            assertEquals(tvShowEntities[index].posterPath, dummyAllTvShows[index].posterPath)
        }

        viewModel.getTvShows().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyAllTvShows)
    }
}