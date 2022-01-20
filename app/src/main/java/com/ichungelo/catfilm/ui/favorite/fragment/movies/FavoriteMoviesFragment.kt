package com.ichungelo.catfilm.ui.favorite.fragment.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.FragmentFavoriteMoviesBinding
import com.ichungelo.catfilm.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment(), SearchView.OnQueryTextListener {
    private var _binding: FragmentFavoriteMoviesBinding? = null
    private val binding get() = _binding
    private var _favoriteMoviesViewModel: FavoriteMoviesViewModel? = null
    private val favoriteMoviesViewModel get() = _favoriteMoviesViewModel
    private var _favoriteMoviesAdapter: FavoriteMoviesAdapter? = null
    private val favoriteMoviesAdapter get() = _favoriteMoviesAdapter

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
        _favoriteMoviesViewModel =
            ViewModelProvider(this, factory)[FavoriteMoviesViewModel::class.java]
        _favoriteMoviesAdapter = FavoriteMoviesAdapter()
        backgroundAndProgressBarVisibility(background = false, progressBar = false)
        favoriteMoviesViewModel?.getAllMoviesFavorite(EMPTY_SEARCH)
            ?.observe(viewLifecycleOwner, { movies ->
                favoriteMoviesAdapter?.submitList(movies)
                if (movies.isEmpty()) {
                    backgroundAndProgressBarVisibility(background = true, progressBar = false)
                }
            })

        binding?.let {
            it.svFavoriteMovies.setOnQueryTextListener(this)
            with(it.rvFavoriteMovies) {
                layoutManager = LinearLayoutManager(activity)
                adapter = favoriteMoviesAdapter
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
            favoriteMoviesViewModel?.getAllMoviesFavorite(searchQuery)
                ?.observe(viewLifecycleOwner, { movies ->
                    favoriteMoviesAdapter?.submitList(movies)
                    if (movies.isEmpty()) {
                        backgroundAndProgressBarVisibility(background = true, progressBar = false)
                        binding?.imgBgFavoriteMovies?.setImageResource(R.drawable.bg_noresult)
                        binding?.tvBgFavoriteMovies?.text = getString(R.string.text_noresult_search)
                    } else {
                        backgroundAndProgressBarVisibility(background = false, progressBar = false)
                    }
                })
        } else {
            favoriteMoviesViewModel?.getAllMoviesFavorite(EMPTY_SEARCH)
                ?.observe(viewLifecycleOwner, { movies ->
                    favoriteMoviesAdapter?.submitList(movies)
                    if (movies.isEmpty()) {
                        backgroundAndProgressBarVisibility(background = true, progressBar = false)
                        binding?.imgBgFavoriteMovies?.setImageResource(R.drawable.bg_nofavorite)
                        binding?.tvBgFavoriteMovies?.text = getString(R.string.add_movies_advice)
                    } else {
                        backgroundAndProgressBarVisibility(background = false, progressBar = false)
                    }
                })
        }
        return true
    }

    private fun backgroundAndProgressBarVisibility(background: Boolean, progressBar: Boolean) {
        if (background) {
            with(binding) {
                this?.imgBgFavoriteMovies?.visibility = View.VISIBLE
                this?.tvBgFavoriteMovies?.visibility = View.VISIBLE
            }
        } else {
            with(binding) {
                this?.imgBgFavoriteMovies?.visibility = View.GONE
                this?.tvBgFavoriteMovies?.visibility = View.GONE
            }
        }
        binding?.progressFavoriteMovies?.visibility = if (progressBar) View.VISIBLE else View.GONE
    }

    companion object {
        const val EMPTY_SEARCH = ""
    }
}