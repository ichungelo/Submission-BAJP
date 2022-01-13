package com.ichungelo.catfilm.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.utils.DataDummy
import com.ichungelo.catfilm.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val selectedMovies = DataDummy.generateRemoteDetailMovie()
    private val selectedTvShow = DataDummy.generateRemoteDetailTvShow()
    private val moviePosition = 2
    private val tvShowPosition = 0
    private val totalMovies = 20
    private val totalTvShows = 20

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(totalMovies))
    }

    @Test
    fun loadTvShows() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(totalTvShows))

    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(moviePosition, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.movies)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(selectedMovies.title)))
        onView(withId(R.id.tv_detail_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tagline)).check(matches(withText("\"${selectedMovies.tagline}\"")))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(withText(selectedMovies.voteAverage.toString())))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(selectedMovies.overview)))
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.tv_detail_homepage)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_homepage)).check(matches(withText(selectedMovies.homepage)))
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(tvShowPosition, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.tv_shows)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(selectedTvShow.title)))
        onView(withId(R.id.tv_detail_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tagline)).check(matches(withText("\"${selectedTvShow.tagline}\"")))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(withText(selectedTvShow.voteAverage.toString())))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(selectedTvShow.overview)))
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.tv_detail_homepage)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_homepage)).check(matches(withText(selectedTvShow.homepage)))
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
    }

    @Test
    fun detailMovieShareButton() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(moviePosition, click()))
        onView(withId(R.id.btn_detail_share)).perform(click())
    }

    @Test
    fun detailTvShowShareButton() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(tvShowPosition, click()))
        onView(withId(R.id.btn_detail_share)).perform(click())
    }

    @Test
    fun detailMovieClickLink() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(moviePosition, click()))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.tv_detail_homepage)).perform(click())
    }

    @Test
    fun detailTvShowClickLink() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(tvShowPosition, click()))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.tv_detail_homepage)).perform(click())
    }
}

