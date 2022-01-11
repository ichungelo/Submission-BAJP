package com.ichungelo.catfilm.ui.main.fragment

import com.ichungelo.catfilm.ui.main.fragment.tvshows.TvShowsViewModel
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DataViewModelTest {

    private lateinit var viewModel: TvShowsViewModel

    @Before
    fun setUp() {
        viewModel = TvShowsViewModel()
    }

    @Test
    fun getMovies() {
        val allMovies = viewModel.getMovies()
        assertNotNull(allMovies)
        assertEquals(19, allMovies.size)
        for (index in allMovies.indices) {
            assertEquals("m${index+1}", allMovies[index].dataId)
        }
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