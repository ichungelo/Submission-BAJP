package com.ichungelo.catfilm.ui.main.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.databinding.FragmentTvShowsBinding

class TvShowsFragment : Fragment() {
    private lateinit var binding: FragmentTvShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[TvShowsViewModel::class.java]
            val tvShows = viewModel.getTvShows()
            val tvShowAdapter = TvShowsAdapter()
            tvShowAdapter.setTvShows(tvShows)
            with(binding.rvTvShows) {
                layoutManager = GridLayoutManager(activity, 2)
                adapter = tvShowAdapter
            }
        }
    }
}