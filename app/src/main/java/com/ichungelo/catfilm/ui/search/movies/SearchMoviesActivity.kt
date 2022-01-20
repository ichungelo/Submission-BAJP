package com.ichungelo.catfilm.ui.search.movies

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivitySearchMoviesBinding
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class SearchMoviesActivity : AppCompatActivity(), View.OnClickListener,
    SearchView.OnQueryTextListener {
    private lateinit var binding: ActivitySearchMoviesBinding
    private lateinit var viewModel: SearchMoviesViewModel
    private lateinit var adapter: SearchMoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backgroundAndProgressBarVisibility(background = true, progressBar = false)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[SearchMoviesViewModel::class.java]
        adapter = SearchMoviesAdapter()

        with(binding) {
            svMovies.setOnQueryTextListener(this@SearchMoviesActivity)
            rvSearchMovies.layoutManager = LinearLayoutManager(this@SearchMoviesActivity)
            rvSearchMovies.adapter = adapter
            btnSearchMoviesBack.setOnClickListener(this@SearchMoviesActivity)
            showSoftKeyboard(svMovies)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_search_movies_back -> onBackPressed()
        }
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        backgroundAndProgressBarVisibility(background = false, progressBar = true)
        query?.let {
            viewModel.getSearchMovies(it).observe(this, { result ->
                adapter.setSearchMovies(result)
                if (result.isNotEmpty()) {
                    backgroundAndProgressBarVisibility(background = false, progressBar = false)
                } else {
                    backgroundAndProgressBarVisibility(background = true, progressBar = false)
                    binding.imgBgSearchMovies.setImageResource(R.drawable.bg_noresult)
                    binding.tvSearchMovies.text = getString(R.string.text_noresult_search)
                }
            })
        }
        binding.svMovies.clearFocus()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }

    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun backgroundAndProgressBarVisibility(background: Boolean, progressBar: Boolean) {
        if (background) {
            with(binding) {
                imgBgSearchMovies.visibility = View.VISIBLE
                tvSearchMovies.visibility = View.VISIBLE
            }
        } else {
            with(binding) {
                imgBgSearchMovies.visibility = View.GONE
                tvSearchMovies.visibility = View.GONE
            }
        }
        binding.progressSearchMovies.visibility = if (progressBar) View.VISIBLE else View.GONE
    }
}