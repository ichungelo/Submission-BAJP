package com.ichungelo.catfilm.ui.search.movies

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivitySearchMoviesBinding

class SearchMoviesActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySearchMoviesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnSearchMoviesBack.setOnClickListener(this@SearchMoviesActivity)
            showSoftKeyboard(svMovies)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_search_movies_back -> onBackPressed()
        }
    }

    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }
}