package com.ichungelo.catfilm.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dataMovies = DataDummy.generateDataMovies()
    private val movieLastIndex = dataMovies.lastIndex
    private val selectedMovies = dataMovies[movieLastIndex]
    private val dataTvShows = DataDummy.generateDataTvShows()
    private val tvShowLastIndex = dataTvShows.lastIndex
    private val selectedTvShow = dataTvShows[tvShowLastIndex]

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movieLastIndex))
    }

    @Test
    fun loadTvShows() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShowLastIndex))

    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movieLastIndex))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(movieLastIndex, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.movies)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(selectedMovies.title)))
        onView(withId(R.id.tv_detail_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tagline)).check(matches(withText("\"${selectedMovies.tagline}\"")))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(withText(selectedMovies.rating)))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(selectedMovies.genre)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText(selectedMovies.year.toString())))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(selectedMovies.overview)))
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShowLastIndex))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(tvShowLastIndex, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.tv_shows)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(selectedTvShow.title)))
        onView(withId(R.id.tv_detail_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tagline)).check(matches(withText("\"${selectedTvShow.tagline}\"")))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(withText(selectedTvShow.rating)))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(selectedTvShow.genre)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText(selectedTvShow.year.toString())))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(selectedTvShow.overview)))
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
    }

    @Test
    fun detailMovieShareButton() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(movieLastIndex))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(movieLastIndex, click()))
        onView(withId(R.id.btn_detail_share)).perform(click())
    }

    @Test
    fun detailTvShowShareButton() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tvShowLastIndex))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(tvShowLastIndex, click()))
        onView(withId(R.id.btn_detail_share)).perform(click())
    }
}

