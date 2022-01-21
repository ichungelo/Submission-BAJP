package com.ichungelo.catfilm.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ichungelo.catfilm.data.source.local.LocalDataSource
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.data.source.remote.RemoteDataSource
import com.ichungelo.catfilm.utils.DataDummy
import com.ichungelo.catfilm.utils.LiveDataTestUtil
import com.ichungelo.catfilm.utils.PagedListUtil
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

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onAllMoviesReceived(movieResponses)
            null
        }.`when`(remote).getAllMovies(any())
        val movieEntities = LiveDataTestUtil.getValue(repository.getMovies())
        verify(remote).getAllMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
        for (index in movieEntities.indices) {
            assertEquals(movieResponses[index].id, movieEntities[index].id)
            assertEquals(movieResponses[index].title, movieEntities[index].title)
            assertEquals(movieResponses[index].releaseDate, movieEntities[index].releaseDate)
            assertEquals(movieResponses[index].posterPath, movieEntities[index].posterPath)
        }
    }

    @Test
    fun getSearchMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadSearchMoviesCallback)
                .onSearchMoviesReceived(movieResponses)
            null
        }.`when`(remote).getSearchMovies(any(),eq(DUMMY_INPUT))
        val movieEntities = LiveDataTestUtil.getValue(repository.getSearchMovies(DUMMY_INPUT))
        verify(remote).getSearchMovies(any(), eq(DUMMY_INPUT))
        assertNotNull(movieEntities)
        assertEquals(movieResponses.size.toLong(), movieEntities.size.toLong())
        for (index in movieEntities.indices) {
            assertEquals(movieResponses[index].id, movieEntities[index].id)
            assertEquals(movieResponses[index].title, movieEntities[index].title)
            assertEquals(movieResponses[index].releaseDate, movieEntities[index].releaseDate)
            assertEquals(movieResponses[index].posterPath, movieEntities[index].posterPath)
        }
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailMovieCallback)
                .onDetailMovieReceived(detailMovie)
            null
        }.`when`(remote).getDetailMovie(any(), eq(movieId))

        val detailMovie = LiveDataTestUtil.getValue(repository.getDetailMovie(movieId))

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
        `when`(local.getAllMoviesFavorite(DUMMY_INPUT)).thenReturn(dataSourceFactory)
        repository.getAllMoviesFavorite(DUMMY_INPUT)

        val movieEntities = PagedListUtil.mockPagedList(DataDummy.generateDataMovies())
        verify(local).getAllMoviesFavorite(DUMMY_INPUT)
        assertNotNull(movieEntities)
        assertEquals(movieLocal.size.toLong(), movieEntities.size.toLong())
        for (index in movieEntities.indices) {
            assertEquals(movieLocal[index].id, movieEntities[index]?.id)
            assertEquals(movieLocal[index].title, movieEntities[index]?.title)
            assertEquals(movieLocal[index].releaseDate, movieEntities[index]?.releaseDate)
            assertEquals(movieLocal[index].posterPath, movieEntities[index]?.posterPath)
        }
    }

    @Test
    fun getMovieById() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = movieById

        `when`(local.getMovieById(eq(movieId))).thenReturn(movie)
        val movieEntity = LiveDataTestUtil.getValue(repository.getMovieById(eq(movieId)))
        verify(local).getMovieById(eq(movieId))
        assertNotNull(movieEntity)
        assertEquals(movieEntity.id, movieLocal[0].id)
        assertEquals(movieEntity.title, movieLocal[0].title)
        assertEquals(movieEntity.releaseDate, movieLocal[0].releaseDate)
        assertEquals(movieEntity.posterPath, movieLocal[0].posterPath)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onAllTvShowsReceived(tvResponses)
            null
        }.`when`(remote).getAllTvShows(any())
        val tvShowEntities = LiveDataTestUtil.getValue(repository.getTvShows())
        verify(remote).getAllTvShows(any())
        assertNotNull(tvShowEntities)
        assertEquals(tvResponses.size.toLong(), tvShowEntities.size.toLong())
        for (index in tvShowEntities.indices) {
            assertEquals(tvResponses[index].id, tvShowEntities[index].id)
            assertEquals(tvResponses[index].title, tvShowEntities[index].title)
            assertEquals(tvResponses[index].releaseDate, tvShowEntities[index].releaseDate)
            assertEquals(tvResponses[index].posterPath, tvShowEntities[index].posterPath)
        }
    }

    @Test
    fun getSearchTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadSearchTvShowsCallback)
                .onSearchTvShowsReceived(tvResponses)
            null
        }.`when`(remote).getSearchTvShows(any(),eq(DUMMY_INPUT))
        val tvEntities = LiveDataTestUtil.getValue(repository.getSearchTvShows(DUMMY_INPUT))
        verify(remote).getSearchTvShows(any(), eq(DUMMY_INPUT))
        assertNotNull(tvEntities)
        assertEquals(tvResponses.size.toLong(), tvEntities.size.toLong())
        for (index in tvEntities.indices) {
            assertEquals(tvResponses[index].id, tvEntities[index].id)
            assertEquals(tvResponses[index].title, tvEntities[index].title)
            assertEquals(tvResponses[index].releaseDate, tvEntities[index].releaseDate)
            assertEquals(tvResponses[index].posterPath, tvEntities[index].posterPath)
        }
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback)
                .onDetailTvShowReceived(detailTvShow)
            null
        }.`when`(remote).getDetailTvShow(any(), eq(tvShowId))

        val detailTvShow = LiveDataTestUtil.getValue(repository.getDetailTvShow(tvShowId))

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
        `when`(local.getAllTvShowsFavorite(DUMMY_INPUT)).thenReturn(dataSourceFactory)
        repository.getAllTvShowsFavorite(DUMMY_INPUT)

        val tvEntities = PagedListUtil.mockPagedList(DataDummy.generateDataTvShows())
        verify(local).getAllTvShowsFavorite(DUMMY_INPUT)
        assertNotNull(tvEntities)
        assertEquals(tvShowLocal.size.toLong(), tvEntities.size.toLong())
        for (index in tvEntities.indices) {
            assertEquals(tvResponses[index].id, tvEntities[index]?.id)
            assertEquals(tvResponses[index].title, tvEntities[index]?.title)
            assertEquals(tvResponses[index].releaseDate, tvEntities[index]?.releaseDate)
            assertEquals(tvResponses[index].posterPath, tvEntities[index]?.posterPath)
        }
    }

    @Test
    fun getTVById() {
        val tvShow = MutableLiveData<TvEntity>()
        tvShow.value = tvShowById

        `when`(local.getTvById(eq(tvShowId))).thenReturn(tvShow)
        val tvEntity = LiveDataTestUtil.getValue(repository.getTvById(eq(tvShowId)))
        verify(local).getTvById(eq(tvShowId))
        assertNotNull(tvEntity)
        assertEquals(tvEntity.id.toString(), tvShowId)
        assertEquals(tvEntity.id, tvShowLocal[0].id)
        assertEquals(tvEntity.title, tvShowLocal[0].title)
        assertEquals(tvEntity.releaseDate, tvShowLocal[0].releaseDate)
        assertEquals(tvEntity.posterPath, tvShowLocal[0].posterPath)
    }

    companion object {
        const val DUMMY_INPUT = ""
    }
}