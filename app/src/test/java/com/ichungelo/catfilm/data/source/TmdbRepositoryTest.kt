package com.ichungelo.catfilm.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ichungelo.catfilm.data.source.local.LocalDataSource
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource
import com.ichungelo.catfilm.util.PagedListUtil
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
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class TmdbRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var remote = mock(RemoteDataSource::class.java)
    private var local = mock(LocalDataSource::class.java)
    private var repository = FakeTmdbRepository(remote, local)

    private val movieResponses = DataDummy.generateRemoteDataMovies()
    private val movieLocal = DataDummy.generateDataMovies()
    private val movieId = movieResponses[0].id.toString()
    private val movieById = movieLocal[0]
    private val tvResponses = DataDummy.generateRemoteDataTvShows()
    private val tvShowLocal = DataDummy.generateDataTvShows()
    private val tvShowId = tvResponses[0].id.toString()
    private val tvShowById = tvShowLocal[0]
    private val detailMovie = DataDummy.generateRemoteDetailMovie()
    private val detailTvShow = DataDummy.generateRemoteDetailTvShow()
    private val dummyQuery = "test"

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtils.getValue(repository.getMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getSearchMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadSearchMoviesCallback)
                .onSearchMoviesReceived(movieResponses)
            null
        }.`when`(remote).getSearchMovies(any(),eq(dummyQuery))
        val movieEntities = LiveDataTestUtils.getValue(repository.getSearchMovies(dummyQuery))
        verify(remote).getSearchMovies(any(), eq(dummyQuery))
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailMovieCallback)
                .onDetailMovieReceived(detailMovie)
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
        assertEquals(movieResponses[0].title, detailMovie.title)
    }

    @Test
    fun getAllMoviesFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getAllMoviesFavorite("")).thenReturn(dataSourceFactory)
        repository.getAllMoviesFavorite("")

        val movieEntities = PagedListUtil.mockPagedList(DataDummy.generateDataMovies())
        verify(local).getAllMoviesFavorite("")
        assertNotNull(movieEntities)
        assertEquals(tvShowLocal.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMovieById() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = movieById

        `when`(local.getMovieById(eq(movieId))).thenReturn(movie)
        val movieEntity = LiveDataTestUtils.getValue(repository.getMovieById(eq(movieId)))
        verify(local).getMovieById(eq(movieId))
        assertNotNull(movieEntity)
        assertEquals(movieEntity.id.toString(), movieId)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvResponses)
            null
        }.`when`(remote).getAllTvShows(any())
        val tvShowEntities = LiveDataTestUtils.getValue(repository.getTvShows())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvResponses.size.toLong(), tvShowEntities.size.toLong())
    }

    @Test
    fun getSearchTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadSearchTvShowsCallback)
                .onSearchTvShowsReceived(tvResponses)
            null
        }.`when`(remote).getSearchTvShows(any(),eq(dummyQuery))
        val tvEntities = LiveDataTestUtils.getValue(repository.getSearchTvShows(dummyQuery))
        verify(remote).getSearchTvShows(any(), eq(dummyQuery))
        assertEquals(tvResponses.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback)
                .onDetailTvShowReceived(detailTvShow)
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
        assertEquals(tvResponses[0].title, detailTvShow.title)
    }

    @Test
    fun getAllTvShowsFavorite() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvEntity>
        `when`(local.getAllTvShowsFavorite("")).thenReturn(dataSourceFactory)
        repository.getAllTvShowsFavorite("")

        val tvEntities = PagedListUtil.mockPagedList(DataDummy.generateDataMovies())
        verify(local).getAllTvShowsFavorite("")
        assertNotNull(tvEntities)
        assertEquals(tvShowLocal.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getTVById() {
        val tvShow = MutableLiveData<TvEntity>()
        tvShow.value = tvShowById

        `when`(local.getTvById(eq(tvShowId))).thenReturn(tvShow)
        val tvEntity = LiveDataTestUtils.getValue(repository.getTvById(eq(tvShowId)))
        verify(local).getTvById(eq(tvShowId))
        assertNotNull(tvEntity)
        assertEquals(tvEntity.id.toString(), tvShowId)
    }
}