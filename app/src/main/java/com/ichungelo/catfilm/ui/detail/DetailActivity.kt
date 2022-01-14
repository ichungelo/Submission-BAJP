package com.ichungelo.catfilm.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ichungelo.catfilm.BuildConfig
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityDetailBinding
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.data.DetailEntity
import com.ichungelo.catfilm.data.source.remote.response.GenreItems
import com.ichungelo.catfilm.viewmodel.ViewModelFactory
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var category: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetailBack.setOnClickListener(this)
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val dataId = intent.getParcelableExtra<DataEntity>(EXTRA_DATA) as DataEntity
        category = intent.extras?.getString(EXTRA_CATEGORY).toString()
        dataId.let {
            viewModel.setDataId(it.id.toString())
        }
        progressBarVisibility(true)

        viewModel.getDetailData(category).observe(this, { dataDetail ->
            progressBarVisibility(false)
            buttonBehavior(dataDetail)
            bindingData(dataDetail)
        })
    }

    private fun buttonBehavior(dataDetail: DetailEntity) {
        with(binding) {
            btnDetailBack.setOnClickListener {
                onBackPressed()
            }
            btnDetailShare.setOnClickListener {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT, """
                        CAT FILM
                        Title: ${dataDetail.title}
                        Release Date: ${setDateFormat(dataDetail.releaseDate)}
                        Rating: ${dataDetail.voteAverage}
                        Genre: ${setGenreFormat(dataDetail.genres)}
                        Overview: ${dataDetail.overview}
                    """.trimIndent()
                    )
                    type = "text/plain"
                }
                val shareIntent = Intent.createChooser(sendIntent, null)
                startActivity(shareIntent)
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_detail_back -> onBackPressed()
        }
    }

    private fun bindingData(dataDetail: DetailEntity) {
        with(binding) {
            with(tvDetailTitle) {
                text = dataDetail.title
                isSelected = true
            }
            tvDetailHomepage.text = dataDetail.homepage
            tvDetailYear.text = setDateFormat(dataDetail.releaseDate)
            tvDetailGenre.text = setGenreFormat(dataDetail.genres)
            tvDetailOverview.text = dataDetail.overview
            tvDetailRating.text = dataDetail.voteAverage.toString()
            with(tvDetailTagline) {
                text = dataDetail.tagline
                isSelected = true
            }
            tvDetailToolbar.text = setToolbarTitle()
            imageGlider(dataDetail.posterPath, imgDetailPoster)
            imageGlider(dataDetail.backdropPath, imgDetailBackdrop)
        }
    }

    private fun setGenreFormat(genre: List<GenreItems>?): String {
        var result = ""
        for (i in genre!!) {
            result += "${i.name}, "
        }
        return result
    }

    private fun setDateFormat(date: String?): String {
        val dateFormatOrigin = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(date!!)
        return SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(dateFormatOrigin!!)
    }

    private fun setToolbarTitle(): String {
        return if (category == resources.getString(R.string.movie_category))
            resources.getString(R.string.movies)
        else
            resources.getString(R.string.tv_shows)
    }

    private fun imageGlider(path: String?, view: ImageView) {
        Glide.with(this@DetailActivity)
            .load("${BuildConfig.IMAGE_URL}t/p/w500/${path}")
            .into(view)
    }

    private fun progressBarVisibility(isLoading: Boolean) {
        binding.progressDetail.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val EXTRA_DATA: String = "extra_data"
        const val EXTRA_CATEGORY: String = "extra_category"
    }
}
