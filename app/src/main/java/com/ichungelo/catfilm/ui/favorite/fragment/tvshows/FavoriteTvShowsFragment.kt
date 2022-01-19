package com.ichungelo.catfilm.ui.favorite.fragment.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ichungelo.catfilm.databinding.FragmentFavoriteTvShowsBinding
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class FavoriteTvShowsFragment : Fragment(), SearchView.OnQueryTextListener {
    private var _binding: FragmentFavoriteTvShowsBinding? = null
    private val binding get() = _binding
    private var _favoriteTvShowsViewModel: FavoriteTvShowsViewModel? = null
    private val favoriteTvShowsViewModel get() = _favoriteTvShowsViewModel
    private var _favoriteTvShowsAdapter: FavoriteTvShowsAdapter? = null
    private val favoriteTvShowsAdapter get() = _favoriteTvShowsAdapter

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

        _favoriteTvShowsViewModel = ViewModelProvider(this, factory)[FavoriteTvShowsViewModel::class.java]
        _favoriteTvShowsAdapter = FavoriteTvShowsAdapter()

        favoriteTvShowsViewModel?.getAllTvShowsFavorite("")?.observe(viewLifecycleOwner, { tvShows ->
                favoriteTvShowsAdapter?.submitList(tvShows)
            })

        binding?.let {
            it.svFavoriteTvShows.setOnQueryTextListener(this)
            with(it.rvFavoriteTvShows) {
                layoutManager = LinearLayoutManager(activity)
                adapter = favoriteTvShowsAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        val searchQuery = "WHERE title LIKE \'%$newText%\'"
        if (!newText.isNullOrEmpty()) {
            favoriteTvShowsViewModel?.getAllTvShowsFavorite(searchQuery)
                ?.observe(viewLifecycleOwner, { tvShows ->
                    favoriteTvShowsAdapter?.submitList(tvShows)
                })
        }
        return true
    }
}