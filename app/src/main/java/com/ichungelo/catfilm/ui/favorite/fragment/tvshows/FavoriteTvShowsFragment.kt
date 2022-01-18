package com.ichungelo.catfilm.ui.favorite.fragment.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ichungelo.catfilm.databinding.FragmentFavoriteTvShowsBinding
import com.ichungelo.catfilm.ui.main.fragment.tvshows.TvShowsAdapter
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

        val favoriteTvShowsViewModel = ViewModelProvider(this, factory)[FavoriteTvShowsViewModel::class.java]
        val favoriteTvShowsAdapter = FavoriteTvShowsAdapter()
        favoriteTvShowsViewModel.getAllTvShowsFavorite().observe(viewLifecycleOwner, { tvShows ->
            favoriteTvShowsAdapter.setFavoriteTvShows(tvShows)
        })

        with(binding?.rvFavoriteTvShows) {
            this?.layoutManager = LinearLayoutManager(activity)
            this?.adapter = favoriteTvShowsAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}