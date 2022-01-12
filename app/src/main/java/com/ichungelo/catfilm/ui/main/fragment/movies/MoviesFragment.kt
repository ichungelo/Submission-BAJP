package com.ichungelo.catfilm.ui.main.fragment.movies

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.databinding.FragmentMoviesBinding
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

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBarVisibility(true)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[MoviesViewModel::class.java]
            val moviesAdapter = MoviesAdapter()
            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                progressBarVisibility(false)
                moviesAdapter.setMovies(movies)
                moviesAdapter.notifyDataSetChanged()
            })
            with(binding?.rvMovies) {
                this?.layoutManager = GridLayoutManager(activity, 2)
                this?.adapter = moviesAdapter
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
}