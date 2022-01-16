package com.ichungelo.catfilm.ui.main.fragment.tvshows

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.FragmentTvShowsBinding
import com.ichungelo.catfilm.ui.favorite.FavoriteActivity
import com.ichungelo.catfilm.ui.search.tvshows.SearchTvShowsActivity
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class TvShowsFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentTvShowsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBarVisibility(true)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]
            val tvShowsAdapter = TvShowsAdapter()
            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                progressBarVisibility(false)
                tvShowsAdapter.setTvShows(tvShows)
            })
            with(binding) {
                if (this?.rvTvShows != null) {
                    rvTvShows.layoutManager = GridLayoutManager(activity, 2)
                    rvTvShows.adapter = tvShowsAdapter
                }
                this?.btnSearchTvShows?.setOnClickListener(this@TvShowsFragment)
                this?.btnTvShowsFavorite?.setOnClickListener(this@TvShowsFragment)
            }
        }
    }
    private fun progressBarVisibility(isLoading: Boolean) {
        binding?.progressTvShows?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_search_tv_shows -> {
                val searchActivityIntent = Intent(activity, SearchTvShowsActivity::class.java)
                startActivity(searchActivityIntent)
            }
            R.id.btn_tv_shows_favorite -> {
                val favoriteActivityIntent = Intent(activity, FavoriteActivity::class.java)
                startActivity(favoriteActivityIntent)
            }
        }
    }
}