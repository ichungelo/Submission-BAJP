package com.ichungelo.catfilm.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.ichungelo.catfilm.data.source.local.entity.DetailEntity
import com.ichungelo.catfilm.data.TmdbRepository
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
class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val selectedMovie = DataDummy.generateDetailMovie()
    private val selectedTvShow = DataDummy.generateDetailTvShow()
    private val movieDataId = selectedMovie.id.toString()
    private val tvShowDataId = selectedTvShow.id.toString()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var tmdbRepository: TmdbRepository

    @Mock
    private lateinit var detailObserver: Observer<DetailEntity>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(tmdbRepository)
    }

    @Test
    fun getDetailMovie() {
        viewModel.setDataId(movieDataId)

        val movie = MutableLiveData<DetailEntity>()
        movie.value = selectedMovie

        Mockito.`when`(tmdbRepository.getDetailMovie(movieDataId)).thenReturn(movie)
        val movieEntity = viewModel.getDetailData("Movies").value as DetailEntity
        Mockito.verify(tmdbRepository).getDetailMovie(movieDataId)
        assertNotNull(movieEntity)
        assertNotNull(movieEntity.id)
        assertNotNull(movieEntity.title)
        assertNotNull(movieEntity.tagline)
        assertNotNull(movieEntity.homepage)
        assertNotNull(movieEntity.releaseDate)
        assertNotNull(movieEntity.backdropPath)
        assertNotNull(movieEntity.genres)
        assertNotNull(movieEntity.posterPath)
        assertNotNull(movieEntity.overview)
        assertNotNull(movieEntity.voteAverage)
        assertEquals(selectedMovie.id, movieEntity.id)
        assertEquals(selectedMovie.title, movieEntity.title)
        assertEquals(selectedMovie.tagline, movieEntity.tagline)
        assertEquals(selectedMovie.homepage, movieEntity.homepage)
        assertEquals(selectedMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(selectedMovie.backdropPath, movieEntity.backdropPath)
        assertEquals(selectedMovie.genres, movieEntity.genres)
        assertEquals(selectedMovie.posterPath, movieEntity.posterPath)
        assertEquals(selectedMovie.overview, movieEntity.overview)
        assertEquals(selectedMovie.voteAverage, movieEntity.voteAverage)

        viewModel.getDetailData("Movies").observeForever(detailObserver)
        verify(detailObserver).onChanged(selectedMovie)
    }

    @Test
    fun getDetailTvShow() {
        viewModel.setDataId(tvShowDataId)

        val tvShow = MutableLiveData<DetailEntity>()
        tvShow.value = selectedTvShow

        Mockito.`when`(tmdbRepository.getDetailTvShow(tvShowDataId)).thenReturn(tvShow)
        val tvShowEntity = viewModel.getDetailData("Tv Shows").value
        Mockito.verify(tmdbRepository).getDetailTvShow(tvShowDataId)
        assertNotNull(tvShowEntity)
        assertNotNull(tvShowEntity?.id)
        assertNotNull(tvShowEntity?.title)
        assertNotNull(tvShowEntity?.tagline)
        assertNotNull(tvShowEntity?.homepage)
        assertNotNull(tvShowEntity?.releaseDate)
        assertNotNull(tvShowEntity?.backdropPath)
        assertNotNull(tvShowEntity?.genres)
        assertNotNull(tvShowEntity?.posterPath)
        assertNotNull(tvShowEntity?.overview)
        assertNotNull(tvShowEntity?.voteAverage)
        assertEquals(selectedTvShow.id, tvShowEntity?.id)
        assertEquals(selectedTvShow.title, tvShowEntity?.title)
        assertEquals(selectedTvShow.tagline, tvShowEntity?.tagline)
        assertEquals(selectedTvShow.homepage, tvShowEntity?.homepage)
        assertEquals(selectedTvShow.releaseDate, tvShowEntity?.releaseDate)
        assertEquals(selectedTvShow.backdropPath, tvShowEntity?.backdropPath)
        assertEquals(selectedTvShow.genres, tvShowEntity?.genres)
        assertEquals(selectedTvShow.posterPath, tvShowEntity?.posterPath)
        assertEquals(selectedTvShow.overview, tvShowEntity?.overview)
        assertEquals(selectedTvShow.voteAverage, tvShowEntity?.voteAverage)

        viewModel.getDetailData("Tv Shows").observeForever(detailObserver)
        verify(detailObserver).onChanged(selectedTvShow)

    }

    @Test
    fun outIndexMovie() {
        val exception = assertThrows(IndexOutOfBoundsException::class.java) {
            DataDummy.generateDataMovies()[10]
        }
        assertEquals("Index 10 out of bounds for length 3", exception.message)
    }

    @Test
    fun outIndexTvShow() {
        val exception = assertThrows(IndexOutOfBoundsException::class.java) {
            DataDummy.generateDataTvShows()[10]
        }
        assertEquals("Index 10 out of bounds for length 3", exception.message)
    }
}