package com.ichungelo.catfilm.ui.main

import android.view.KeyEvent
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
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))
    }

    @Test
    fun loadTvShows() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(19))

    }

    @Test
    fun loadDetailMovie() {
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.movies)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.tv_detail_homepage)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.tv_shows)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.tv_detail_homepage)).check(matches(isDisplayed()))
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
    }

    @Test
    fun detailMovieShareButton() {
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_detail_share)).perform(click())
    }

    @Test
    fun detailTvShowShareButton() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_detail_share)).perform(click())
    }

    @Test
    fun detailMovieClickLink() {
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.tv_detail_homepage)).perform(click())
    }

    @Test
    fun detailTvShowClickLink() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.tv_detail_homepage)).perform(click())
    }

    @Test
    fun addAndRemoveFavoriteMovie() {
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.btn_detail_favorite)).perform(click())
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.btn_movies_favorite)).perform(click())
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.rv_favorite_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_detail_favorite)).perform(click())
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.img_bg_favorite_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun addAndRemoveFavoriteTvShow() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.img_detail_backdrop)).perform(swipeUp())
        onView(withId(R.id.tv_detail_overview)).perform(swipeUp())
        onView(withId(R.id.btn_detail_favorite)).perform(click())
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.btn_tv_shows_favorite)).perform(click())
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.rv_favorite_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.btn_detail_favorite)).perform(click())
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.img_bg_favorite_tv_shows)).check(matches(isDisplayed()))
    }

    @Test
    fun searchMovie() {
        onView(withText("Movies")).perform(click())
        onView(withId(R.id.btn_search_movies)).perform(click())
        onView(withId(R.id.sv_movies)).perform(typeText(selectedMovies.title), pressKey(KeyEvent.KEYCODE_ENTER))
        onView(withId(R.id.rv_search_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.movies)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(selectedMovies.title)))
        onView(withId(R.id.tv_detail_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tagline)).check(matches(withText(selectedMovies.tagline)))
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
        onView(withId(R.id.rv_search_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun searchTvShows() {
        onView(withText("Tv Shows")).perform(click())
        onView(withId(R.id.btn_search_tv_shows)).perform(click())
        onView(withId(R.id.sv_tv_shows)).perform(typeText(selectedTvShow.title), pressKey(KeyEvent.KEYCODE_ENTER))
        onView(withId(R.id.rv_search_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.tv_shows)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(selectedTvShow.title)))
        onView(withId(R.id.tv_detail_tagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_tagline)).check(matches(withText(selectedTvShow.tagline)))
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
        onView(withId(R.id.rv_search_tv_shows)).check(matches(isDisplayed()))
    }
}