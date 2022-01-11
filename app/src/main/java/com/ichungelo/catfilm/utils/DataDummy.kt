package com.ichungelo.catfilm.utils

import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.data.DetailEntity
import com.ichungelo.catfilm.data.source.remote.response.GenreItems
import kotlin.collections.ArrayList

object DataDummy {
    //butuh di update dengan spek sama seperti movie, tvShow, detail Entity
    fun generateDataMovies(): List<DataEntity> {
        val allDataMovies = ArrayList<DataEntity>()

        allDataMovies.add(
            DataEntity(
                634649,
                "Spider-Man: No Way Home",
                "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            )
        )

        allDataMovies.add(
            DataEntity(
                568124,
                "Encanto",
                "/4j0PNHkMr5ax3IA8tjtxcmPU3QT.jpg"
            )
        )

        allDataMovies.add(
            DataEntity(
                460458,
                "Resident Evil: Welcome to Raccoon City",
                "/7uRbWOXxpWDMtnsd2PF3clu65jc.jpg"
            )
        )

        return allDataMovies
    }

    fun generateDetailMovie(): DetailEntity {
        return DetailEntity(
            listOf(
                GenreItems(28, "Action"),
                GenreItems(12, "Adventure"),
                GenreItems(878, "Science Fiction")
            ),
            "/AvnqpRwlEaYNVL6wzC4RN94EdSd.jpg",
            "https://www.spidermannowayhome.movie",
            634649,
            "Spider-Man: No Way Home",
            "Peter Parker is unmasked and no longer able to separate his normal life from the high-stakes of being a super-hero. When he asks for help from Doctor Strange the stakes become even more dangerous, forcing him to discover what it truly means to be Spider-Man.",
            "/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg",
            "The Multiverse unleashed.",
            8.4,
            "2021-12-15"
        )
    }

    fun generateDataTvShows(): List<DataEntity> {
        val allDataTvShows = ArrayList<DataEntity>()

        allDataTvShows.add(
            DataEntity(
                77169,
                "Cobra Kai",
                "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg"
            )
        )

        allDataTvShows.add(
            DataEntity(
                115036,
                "The Book of Boba Fett",
                "/gNbdjDi1HamTCrfvM9JeA94bNi2.jpg"
            )
        )

        allDataTvShows.add(
            DataEntity(
                71914,
                "The Wheel of Time",
                "/mpgDeLhl8HbhI03XLB7iKO6M6JE.jpg"
            )
        )

        return allDataTvShows
    }

    fun generateDetailTvShow(): DetailEntity {
        return DetailEntity(
            listOf(
                GenreItems(10759, "Action & Adventure"),
                GenreItems(18, "Drama")
            ),
            "/35SS0nlBhu28cSe7TiO3ZiywZhl.jpg",
            "https://www.netflix.com/title/81002370",
            77169,
            "Cobra Kai",
            "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
            "/6POBWybSBDBKjSs1VAQcnQC1qyt.jpg",
            "Fight for the soul of the valley.",
            8.1,
            "2018-05-02"
        )
    }
}