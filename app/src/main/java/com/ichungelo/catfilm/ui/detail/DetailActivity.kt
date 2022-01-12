package com.ichungelo.catfilm.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ichungelo.catfilm.BuildConfig
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityDetailBinding
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.data.DetailEntity
import com.ichungelo.catfilm.viewmodel.ViewModelFactory
import java.util.*

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var category: String
    private lateinit var genreList: String
    private lateinit var releaseDate: String
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
                        Release Date: ${dataDetail.releaseDate}
                        Rating: ${dataDetail.voteAverage}
                        Genre: $genreList
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

    @SuppressLint("NewApi")
    private fun bindingData(dataDetail: DetailEntity) {
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(dataDetail.releaseDate)
        var genre = ""
        for (i in dataDetail.genres!!) {
            genre += "${i.name}, "
        }
        releaseDate = SimpleDateFormat("dd MMMM yyyy", Locale.US).format(date)
        genreList = genre

        with(binding) {
            with(tvDetailTitle) {
                text = dataDetail.title
                isSelected = true
            }

            if (dataDetail.homepage.isNullOrEmpty()) {
                tvDetailHomepage.visibility = View.GONE
                tvDetailHomepageTitle.visibility = View.GONE
            } else {
                tvDetailHomepage.text = dataDetail.homepage
            }

            tvDetailYear.text = releaseDate
            tvDetailGenre.text = genreList
            tvDetailOverview.text = dataDetail.overview
            tvDetailRating.text = dataDetail.voteAverage.toString()
            with(tvDetailTagline) {
                text = if (dataDetail.tagline != null)
                    resources.getString(R.string.quotation_mark, dataDetail.tagline)
                else
                    ""
                isSelected = true
            }
            tvDetailToolbar.text = if (category == resources.getString(R.string.movies))
                    resources.getString(R.string.movies)
                else
                    resources.getString(R.string.tv_shows)
            Glide.with(this@DetailActivity)
                .load("${BuildConfig.IMAGE_URL}t/p/w500/${dataDetail.posterPath}")
                .into(imgDetailPoster)
            Glide.with(this@DetailActivity)
                .load("${BuildConfig.IMAGE_URL}t/p/w500/${dataDetail.backdropPath}")
                .into(imgDetailBackdrop)

        }
    }

    private fun progressBarVisibility(isLoading: Boolean) {
        binding.progressDetail.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val EXTRA_DATA: String = "extra_data"
        const val EXTRA_CATEGORY: String = "extra_category"
    }
}
