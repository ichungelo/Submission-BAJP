package com.ichungelo.catfilm.ui.main.fragment.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.databinding.FragmentMoviesBinding
import com.ichungelo.catfilm.ui.main.fragment.DataAdapter
import com.ichungelo.catfilm.ui.main.fragment.DataViewModel

class MoviesFragment : Fragment() {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[DataViewModel::class.java]
            val movies = viewModel.getMovies()
            val moviesAdapter = DataAdapter()
            moviesAdapter.setData(movies)
            with(binding.rvMovies) {
                layoutManager = GridLayoutManager(activity, 2)
                adapter = moviesAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}