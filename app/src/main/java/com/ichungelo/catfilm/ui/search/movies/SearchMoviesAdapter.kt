package com.ichungelo.catfilm.ui.search.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.databinding.ItemsResultBinding
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.ui.detail.DetailViewModel.Companion.MOVIE
import com.ichungelo.catfilm.utils.DiffCallback
import com.ichungelo.catfilm.utils.Helper

class SearchMoviesAdapter : RecyclerView.Adapter<SearchMoviesAdapter.SearchMoviesViewHolder>() {
    private val listSearchMovies = ArrayList<DataEntity>()

    fun setSearchMovies(movies: List<DataEntity>?) {
        if (movies == null) return
        val diffCallback = DiffCallback(this.listSearchMovies, movies)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listSearchMovies.clear()
        this.listSearchMovies.addAll(movies)
        diffResult.dispatchUpdatesTo(this)
    }

    class SearchMoviesViewHolder(private val binding: ItemsResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataEntity) {
            with(binding) {
                tvResultTitle.text = movie.title
                tvResultReleraseDate.text = Helper.changeDateFormat(movie.releaseDate)
                Helper.imageGlider(itemView.context, movie.posterPath, imgResult)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, movie)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, MOVIE)
                    itemView.context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchMoviesViewHolder {
        val binding = ItemsResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchMoviesViewHolder, position: Int) {
        val movie = listSearchMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listSearchMovies.size
}