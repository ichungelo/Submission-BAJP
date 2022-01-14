package com.ichungelo.catfilm.ui.favorite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityFavoriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFavoriteBack.setOnClickListener(this)
        }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_favorite_back -> onBackPressed()
    }
}
}