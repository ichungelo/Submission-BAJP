package com.ichungelo.catfilm.ui.search.tvshows

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ActivitySearchTvShowsBinding
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class SearchTvShowsActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivitySearchTvShowsBinding
    private lateinit var viewModel: SearchTvShowsViewModel
    private lateinit var adapter: SearchTvShowsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchTvShowsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[SearchTvShowsViewModel::class.java]
        adapter = SearchTvShowsAdapter()
        viewModel.getSearchTvShows().observe(this, { result ->
            adapter.setSearchTvShows(result)
        })

        with(binding) {
            rvSearchTvShows.layoutManager = LinearLayoutManager(this@SearchTvShowsActivity)
            rvSearchTvShows.adapter = adapter
            btnSearchTvShowsBack.setOnClickListener(this@SearchTvShowsActivity)
            showSoftKeyboard(svTvShows)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_search_tv_shows_back -> onBackPressed()
        }
    }

    private fun showSoftKeyboard(view: View) {
        if (view.requestFocus()) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
        }
    }}