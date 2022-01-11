package com.ichungelo.catfilm.ui.main.fragment.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.databinding.FragmentMoviesBinding
import com.ichungelo.catfilm.ui.main.fragment.tvshows.TvShowsAdapter
import com.ichungelo.catfilm.ui.main.fragment.tvshows.TvShowsViewModel
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class MoviesFragment : Fragment() {
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

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
            val moviesAdapter = MoviesAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                moviesAdapter.setMovies(movies)
                moviesAdapter.notifyDataSetChanged()
            })
            with(binding?.rvMovies) {
                this?.layoutManager = GridLayoutManager(activity, 2)
                this?.adapter = moviesAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}