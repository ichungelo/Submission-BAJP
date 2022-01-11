package com.ichungelo.catfilm.ui.detail

import android.content.Intent
import android.media.tv.TvContract.Programs.Genres.MOVIES
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

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private var category: String? = null
    private lateinit var binding: ActivityDetailBinding
    private var genreList: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetailBack.setOnClickListener(this)
        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val dataId = intent.getParcelableExtra<DataEntity>(EXTRA_DATA) as DataEntity
        category = intent.extras?.getString(EXTRA_CATEGORY)
        dataId.let {
            viewModel.setDataId(it.id.toString())
            viewModel.setDetail(category)
        }
        viewModel.getDetailData().observe(this, { dataDetail ->
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
                        Year: ${dataDetail.releaseDate}
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

    private fun bindingData(dataDetail: DetailEntity) {
        for (i in dataDetail.genres!!) {
            genreList += "${i.name}, "
        }
        with(binding) {
            with(tvDetailTitle) {
                text = dataDetail.title
                isSelected = true
            }
            tvDetailHomepage.text = dataDetail.homepage
            tvDetailYear.text = dataDetail.releaseDate
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
            tvDetailToolbar.text = if (category == "movie")
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

    companion object {
        const val EXTRA_DATA: String = "extra_data"
        const val EXTRA_CATEGORY: String = "extra_category"
    }
}
