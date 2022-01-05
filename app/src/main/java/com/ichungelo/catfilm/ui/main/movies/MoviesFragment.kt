package com.ichungelo.catfilm.ui.main.movies

import android.content.res.Configuration
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {
    private lateinit var binding: FragmentMoviesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[MoviesViewModel::class.java]
            val movies = viewModel.getMovies()
            val moviesAdapter = MoviesAdapter()
            moviesAdapter.setMovies(movies)
            with(binding.rvMovies) {
                layoutManager = GridLayoutManager(activity, 2)
                adapter = moviesAdapter
            }
        }
    }
}