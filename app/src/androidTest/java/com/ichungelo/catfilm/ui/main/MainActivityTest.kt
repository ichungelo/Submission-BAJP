package com.ichungelo.catfilm.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.utils.Data
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dataMovies = Data.generateDataMovies()
    private val dataTvShows = Data.generateDataTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataMovies.size))
    }

    @Test
    fun loadTvShows() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataTvShows.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.movies)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dataMovies[0].title)))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(withText(dataMovies[0].rating)))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dataMovies[0].genre)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText(dataMovies[0].year.toString())))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dataMovies[0].overview)))
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withId(R.id.rv_movies)).perform(swipeLeft())
        onView(withId(R.id.rv_tv_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_detail_toolbar)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_toolbar)).check(matches(withText(R.string.tv_shows)))
        onView(withId(R.id.img_detail_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(dataTvShows[0].title)))
        onView(withId(R.id.tv_detail_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_rating)).check(matches(withText(dataTvShows[0].rating)))
        onView(withId(R.id.img_detail_poster)).perform(swipeUp())
        onView(withId(R.id.tv_detail_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre)).check(matches(withText(dataTvShows[0].genre)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText(dataTvShows[0].year.toString())))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dataTvShows[0].overview)))
        onView(withId(R.id.btn_detail_back)).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
    }
}

