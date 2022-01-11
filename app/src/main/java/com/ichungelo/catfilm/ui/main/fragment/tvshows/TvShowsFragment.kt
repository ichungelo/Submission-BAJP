package com.ichungelo.catfilm.ui.main.fragment.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ichungelo.catfilm.databinding.FragmentTvShowsBinding
import com.ichungelo.catfilm.ui.main.fragment.DataAdapter
import com.ichungelo.catfilm.ui.main.fragment.DataViewModel

class TvShowsFragment : Fragment() {
    private var _binding: FragmentTvShowsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTvShowsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val viewModel = ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            )[DataViewModel::class.java]
            val tvShows = viewModel.getTvShows()
            val tvShowAdapter = DataAdapter()
            tvShowAdapter.setData(tvShows)
            with(binding?.rvTvShows) {
                this?.layoutManager = GridLayoutManager(activity, 2)
                this?.adapter = tvShowAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}