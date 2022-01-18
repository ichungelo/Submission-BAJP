package com.ichungelo.catfilm.ui.favorite.fragment.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ichungelo.catfilm.databinding.FragmentFavoriteMoviesBinding
import com.ichungelo.catfilm.ui.main.fragment.movies.MoviesAdapter
import com.ichungelo.catfilm.ui.main.fragment.movies.MoviesViewModel
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment() {
    private var _binding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireActivity())
        val favoriteMoviesViewModel = ViewModelProvider(this, factory)[FavoriteMoviesViewModel::class.java]
        val favoriteMoviesAdapter = FavoriteMoviesAdapter()
        favoriteMoviesViewModel.getAllMoviesFavorite().observe(viewLifecycleOwner, { movies ->
            favoriteMoviesAdapter.setFavoriteMovies(movies)
        })

        with(binding?.rvFavoriteMovies) {
            this?.layoutManager = LinearLayoutManager(activity)
            this?.adapter = favoriteMoviesAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}