package com.ichungelo.catfilm.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource
import com.ichungelo.catfilm.utils.DataDummy
import com.ichungelo.catfilm.utils.LiveDataTestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class TmdbRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var remote = mock(RemoteDataSource::class.java)
    private var repository = FakeTmdbRepository(remote)

    private val discoverMovieResponses = DataDummy.generateRemoteDataMovies()
    private val movieId = discoverMovieResponses[0].id.toString()
    private val discoverTvResponses = DataDummy.generateRemoteDataTvShows()
    private val tvShowId = discoverTvResponses[0].id.toString()
    private val discoverDetailMovie = DataDummy.generateRemoteDetailMovie()
    private val discoverDetailTvShow = DataDummy.generateRemoteDetailTvShow()

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(discoverMovieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtils.getValue(repository.getMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(discoverMovieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailMovieCallback)
                .onDetailMovieReceived(discoverDetailMovie)
            null
        }.`when`(remote).getDetailMovie(any(), eq(movieId))

        val detailMovie = LiveDataTestUtils.getValue(repository.getDetailMovie(movieId))

        verify(remote).getDetailMovie(any(), eq(movieId))

        assertNotNull(detailMovie)
        assertNotNull(detailMovie.releaseDate)
        assertNotNull(detailMovie.backdropPath)
        assertNotNull(detailMovie.genres)
        assertNotNull(detailMovie.posterPath)
        assertNotNull(detailMovie.voteAverage)
        assertNotNull(detailMovie.title)
        assertNotNull(detailMovie.tagline)
        assertNotNull(detailMovie.id)
        assertNotNull(detailMovie.overview)
        assertNotNull(detailMovie.homepage)
        assertEquals(discoverMovieResponses[0].title, detailMovie.title)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(discoverTvResponses)
            null
        }.`when`(remote).getAllTvShows(any())
        val tvShowEntities = LiveDataTestUtils.getValue(repository.getTvShows())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(discoverTvResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback)
                .onDetailTvShowReceived(discoverDetailTvShow)
            null
        }.`when`(remote).getDetailTvShow(any(), eq(tvShowId))

        val detailTvShow = LiveDataTestUtils.getValue(repository.getDetailTvShow(tvShowId))

        verify(remote).getDetailTvShow(any(), eq(tvShowId))

        assertNotNull(detailTvShow)
        assertNotNull(detailTvShow.releaseDate)
        assertNotNull(detailTvShow.backdropPath)
        assertNotNull(detailTvShow.genres)
        assertNotNull(detailTvShow.posterPath)
        assertNotNull(detailTvShow.voteAverage)
        assertNotNull(detailTvShow.title)
        assertNotNull(detailTvShow.tagline)
        assertNotNull(detailTvShow.id)
        assertNotNull(detailTvShow.overview)
        assertNotNull(detailTvShow.homepage)
        assertEquals(discoverTvResponses[0].title, detailTvShow.title)
    }
}