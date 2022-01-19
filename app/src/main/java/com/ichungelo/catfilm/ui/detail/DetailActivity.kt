package com.ichungelo.catfilm.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityDetailBinding
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.DetailEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.utils.Helper
import com.ichungelo.catfilm.viewmodel.ViewModelFactory
import java.util.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var movieExtra: MovieEntity? = null
    private var tvExtra: TvEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetailBack.setOnClickListener(this)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        movieExtra = intent.getParcelableExtra(EXTRA_MOVIE)
        tvExtra = intent.getParcelableExtra(EXTRA_TV)
        progressBarVisibility(true)
        movieExtra?.let {
            viewModel.getDetailMovie(it.id.toString()).observe(this, { movieResult ->
                progressBarVisibility(false)
                buttonShareBehavior(movieResult)
                buttonFavoriteBehaviour(
                    movieResult.id.toString(),
                    resources.getString(R.string.movies)
                )
                bindingData(movieResult, resources.getString(R.string.movies))
            })
        }
        tvExtra?.let {
            viewModel.getDetailTvShow(it.id.toString()).observe(this, { tvResult ->
                progressBarVisibility(false)
                buttonShareBehavior(tvResult)
                buttonFavoriteBehaviour(
                    tvResult.id.toString(),
                    resources.getString(R.string.tv_shows)
                )
                bindingData(tvResult, resources.getString(R.string.tv_shows))
            })
        }
    }

    private fun buttonFavoriteBehaviour(id: String, mediaType: String) {
        if (mediaType == resources.getString(R.string.movies)) {
            viewModel.getMovieById(id).observe(this@DetailActivity, { movieId ->
                if (movieId != null) {
                    with(binding.btnDetailFavorite) {
                        setOnClickListener {
                            viewModel.deleteMovieFavorite(intent.getParcelableExtra(EXTRA_MOVIE)!!)
                            movieExtra?.title?.let {
                                Helper.favoriteRemovedToast(this@DetailActivity, it)
                            }
                        }
                        setImageResource(R.drawable.ic_heart)
                    }
                } else {
                    with(binding.btnDetailFavorite) {
                        setOnClickListener {
                            viewModel.insertMovieFavorite(intent.getParcelableExtra(EXTRA_MOVIE)!!)
                            movieExtra?.title?.let { Helper.favoriteAddedToast(this@DetailActivity, it)
                            }
                        }
                        setImageResource(R.drawable.ic_heart_unselected)
                    }
                }
            })
        } else if (mediaType == resources.getString(R.string.tv_shows)) {
            viewModel.getTvById(id).observe(this@DetailActivity, { tvId ->
                if (tvId != null) {
                    with(binding.btnDetailFavorite) {
                        setOnClickListener {
                            viewModel.deleteTvFavorite(intent.getParcelableExtra(EXTRA_TV)!!)
                            tvExtra?.title?.let {
                                Helper.favoriteRemovedToast(this@DetailActivity, it)
                            }
                        }
                        setImageResource(R.drawable.ic_heart)
                    }
                } else {
                    with(binding.btnDetailFavorite) {
                        setOnClickListener {
                            viewModel.insertTvFavorite(intent.getParcelableExtra(EXTRA_TV)!!)
                            tvExtra?.title?.let { Helper.favoriteAddedToast(this@DetailActivity, it)
                            }
                        }
                        setImageResource(R.drawable.ic_heart_unselected)
                    }
                }
            })
        }
    }

    private fun buttonShareBehavior(dataDetail: DetailEntity) {
        binding.btnDetailShare.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT, """
                        CAT FILM
                        Title: ${dataDetail.title}
                        Release Date: ${Helper.changeDateFormat(dataDetail.releaseDate)}
                        Rating: ${dataDetail.voteAverage}
                        Genre: ${Helper.setGenreFormat(dataDetail.genres)}
                        Overview: ${dataDetail.overview}
                    """.trimIndent()
                )
                type = "text/plain"
            }
            val shareIntent = Intent.createChooser(sendIntent, null)
            startActivity(shareIntent)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_detail_back -> onBackPressed()
        }
    }

    private fun bindingData(dataDetail: DetailEntity, mediaType: String) {
        with(binding) {
            with(tvDetailTitle) {
                text = dataDetail.title
                isSelected = true
            }
            tvDetailHomepage.text = dataDetail.homepage
            tvDetailYear.text = Helper.changeDateFormat(dataDetail.releaseDate)
            tvDetailGenre.text = Helper.setGenreFormat(dataDetail.genres)
            tvDetailOverview.text = dataDetail.overview
            tvDetailRating.text = dataDetail.voteAverage.toString()
            with(tvDetailTagline) {
                text = dataDetail.tagline
                isSelected = true
            }
            tvDetailToolbar.text = mediaType
            Helper.imageGlider(this@DetailActivity, dataDetail.posterPath, imgDetailPoster)
            Helper.imageGlider(this@DetailActivity, dataDetail.backdropPath, imgDetailBackdrop)
        }
    }

    private fun progressBarVisibility(isLoading: Boolean) {
        binding.progressDetail.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val EXTRA_MOVIE: String = "extra_movie"
        const val EXTRA_TV: String = "extra_tv"
    }
}
