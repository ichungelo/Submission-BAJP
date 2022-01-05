package com.ichungelo.catfilm.ui.main.movies

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
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
}