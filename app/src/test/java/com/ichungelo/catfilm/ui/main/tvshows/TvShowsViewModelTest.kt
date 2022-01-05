package com.ichungelo.catfilm.ui.main.tvshows

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class TvShowsViewModelTest {
    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel()
    }

    @Test
    fun getTvShows() {
        val allTvShows = viewModel.getTvShows()
        assertNotNull(allTvShows)
        assertEquals(20, allTvShows.size)
        for (index in allTvShows.indices) {
            assertEquals("t${index+1}", allTvShows[index].dataId)
        }
    }
}