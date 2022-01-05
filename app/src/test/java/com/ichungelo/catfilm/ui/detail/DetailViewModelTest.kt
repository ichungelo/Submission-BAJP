package com.ichungelo.catfilm.ui.detail

import com.ichungelo.catfilm.utils.Data
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val selectedMovie = Data.generateDataMovies()[0]
    private val selectedTvShow = Data.generateDataTvShows()[0]
    private val movieDataId = selectedMovie.dataId
    private val tvShowDataId = selectedTvShow.dataId


    @Before
    fun setUp() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getListData() {
        assertEquals('m', movieDataId[0])
        assertNotEquals('m', tvShowDataId[0])
    }

    @Test
    fun getMovie() {
        viewModel.setDataId(movieDataId)
        val dataEntity = viewModel.getDetailById()
        assertNotNull(dataEntity)
        assertEquals(selectedMovie.dataId, dataEntity.dataId)
        assertEquals(selectedMovie.title, dataEntity.title)
        assertEquals(selectedMovie.year, dataEntity.year)
        assertEquals(selectedMovie.rating, dataEntity.rating)
        assertEquals(selectedMovie.genre, dataEntity.genre)
        assertEquals(selectedMovie.tagline, dataEntity.tagline)
        assertEquals(selectedMovie.overview, dataEntity.overview)
        assertEquals(selectedMovie.poster, dataEntity.poster)
    }

    @Test
    fun getTvShow() {
        viewModel.setDataId(tvShowDataId)
        val dataEntity = viewModel.getDetailById()
        assertNotNull(dataEntity)
        assertEquals(selectedTvShow.dataId, dataEntity.dataId)
        assertEquals(selectedTvShow.title, dataEntity.title)
        assertEquals(selectedTvShow.year, dataEntity.year)
        assertEquals(selectedTvShow.rating, dataEntity.rating)
        assertEquals(selectedTvShow.genre, dataEntity.genre)
        assertEquals(selectedTvShow.tagline, dataEntity.tagline)
        assertEquals(selectedTvShow.overview, dataEntity.overview)
        assertEquals(selectedTvShow.poster, dataEntity.poster)
    }

    @Test
    fun outIndexMovie() {
        val exception = assertThrows(IndexOutOfBoundsException::class.java) {
            Data.generateDataMovies()[19]
        }
        assertEquals("Index 19 out of bounds for length 19", exception.message)
    }

    @Test
    fun outIndexTvShow() {
        val exception = assertThrows(IndexOutOfBoundsException::class.java) {
            Data.generateDataTvShows()[20]
        }
        assertEquals("Index 20 out of bounds for length 20", exception.message)
    }
}