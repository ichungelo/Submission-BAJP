package com.ichungelo.catfilm.ui.main.fragment.movies

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.FragmentMoviesBinding
import com.ichungelo.catfilm.ui.favorite.FavoriteActivity
import com.ichungelo.catfilm.ui.search.movies.SearchMoviesActivity
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class MoviesFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBarVisibility(true)

        binding?.btnSearchMovies?.setOnClickListener(this)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
            val moviesAdapter = MoviesAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                progressBarVisibility(false)
                moviesAdapter.setMovies(movies)
            })
            with(binding) {
                if (this?.rvMovies != null) {
                    rvMovies.layoutManager = GridLayoutManager(activity, 2)
                    rvMovies.adapter = moviesAdapter
                }
                this?.btnSearchMovies?.setOnClickListener(this@MoviesFragment)
                this?.btnMoviesFavorite?.setOnClickListener(this@MoviesFragment)
            }
        }
    }

    private fun progressBarVisibility(isLoading: Boolean) {
        binding?.progressMovies?.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_search_movies -> {
                val searchActivityIntent = Intent(activity, SearchMoviesActivity::class.java)
                startActivity(searchActivityIntent)
            }
            R.id.btn_movies_favorite -> {
                val favoriteActivityIntent = Intent(activity, FavoriteActivity::class.java)
                startActivity(favoriteActivityIntent)
            }
        }
    }
}