package com.ichungelo.catfilm.ui.favorite.fragment.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.ichungelo.catfilm.data.TmdbRepository
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowsViewModelTest {

    private lateinit var viewModel: FavoriteTvShowsViewModel

    @get:Rule
    var instantTaskExecutorRule =InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var tvShowObserver: Observer<PagedList<TvEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvEntity>

    @Before
    fun setUp() {
        viewModel = FavoriteTvShowsViewModel(tmdbRepository)
    }

    @Test
    fun getAllTvShowsFavorite() {
        val dummy = pagedList
        `when`(dummy.size).thenReturn(10)
        val favoriteTvShows = MutableLiveData<PagedList<TvEntity>>()
        favoriteTvShows.value = dummy

        `when`(tmdbRepository.getAllTvShowsFavorite(DUMMY_TITLE)).thenReturn(favoriteTvShows)
        val tvEntities = viewModel.getAllTvShowsFavorite(DUMMY_TITLE).value as List<TvEntity>
        verify(tmdbRepository).getAllTvShowsFavorite(DUMMY_TITLE)
        assertNotNull(tvEntities)
        assertEquals(10, tvEntities.size)
        viewModel.getAllTvShowsFavorite(DUMMY_TITLE).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummy)
    }

    companion object {
        const val DUMMY_TITLE = ""
    }
}