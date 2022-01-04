package com.ichungelo.catfilm.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityDetailBinding
import com.ichungelo.catfilm.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDetailBack.setOnClickListener(this)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_detail_back -> onBackPressed()
        }
    }
}