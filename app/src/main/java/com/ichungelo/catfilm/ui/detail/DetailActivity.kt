package com.ichungelo.catfilm.ui.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityDetailBinding
import com.ichungelo.catfilm.model.DataEntity

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailBinding
    private lateinit var dataDetail: DataEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetailBack.setOnClickListener(this)

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailViewModel::class.java]

        val dataId = intent.getStringExtra(EXTRA_DATA)

        dataId?.let {
            viewModel.setDataId(it)
        }
        dataDetail = viewModel.getDetailById()

        bindingData()
        buttonBehavior()
    }

    private fun buttonBehavior() {
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
                        Year: ${dataDetail.year}
                        Rating: ${dataDetail.rating}
                        Genre: ${dataDetail.genre}
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

    private fun bindingData() {
        with(binding) {
            with(tvDetailTitle) {
                text = dataDetail.title
                isSelected = true
            }
            tvDetailYear.text = dataDetail.year.toString()
            tvDetailGenre.text = dataDetail.genre
            tvDetailOverview.text = dataDetail.overview
            tvDetailRating.text = dataDetail.rating
            with(tvDetailTagline) {
                text = if (dataDetail.tagline.isNotEmpty())
                    resources.getString(R.string.quotation_mark, dataDetail.tagline)
                else
                    ""
                isSelected = true
            }
            tvDetailToolbar.text = if (dataDetail.dataId[0] == 'm')
                    resources.getString(R.string.movies)
                else
                    resources.getString(R.string.tv_shows)
            Glide.with(this@DetailActivity)
                .load(dataDetail.poster)
                .into(imgDetailPoster)
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}
