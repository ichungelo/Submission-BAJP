package com.ichungelo.catfilm.ui.favorite.fragment.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.databinding.FragmentFavoriteTvShowsBinding
import com.ichungelo.catfilm.ui.main.fragment.tvshows.TvShowsAdapter
import com.ichungelo.catfilm.ui.main.fragment.tvshows.TvShowsViewModel
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class FavoriteTvShowsFragment : Fragment() {
    private var _binding: FragmentFavoriteTvShowsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteTvShowsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())

        val tvViewModel = ViewModelProvider(this, factory)[TvShowsViewModel::class.java]
        val tvShowsAdapter = TvShowsAdapter()
        tvViewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
            tvShowsAdapter.setTvShows(tvShows)
        })

        with(binding?.rvFavoriteTvShows) {
            this?.layoutManager = GridLayoutManager(activity,2)
            this?.adapter = tvShowsAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}