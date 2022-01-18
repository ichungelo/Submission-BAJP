package com.ichungelo.catfilm.ui.search.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.databinding.ItemsResultBinding
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.utils.MovieDiffCallback
import com.ichungelo.catfilm.utils.Helper

class SearchMoviesAdapter : RecyclerView.Adapter<SearchMoviesAdapter.SearchMoviesViewHolder>() {
    private val listSearchMovies = ArrayList<MovieEntity>()

    fun setSearchMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        val diffCallback = MovieDiffCallback(this.listSearchMovies, movies)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listSearchMovies.clear()
        this.listSearchMovies.addAll(movies)
        diffResult.dispatchUpdatesTo(this)
    }

    class SearchMoviesViewHolder(private val binding: ItemsResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvResultTitle.text = movie.title
                tvResultReleraseDate.text = Helper.changeDateFormat(movie.releaseDate)
                Helper.imageGlider(itemView.context, movie.posterPath, imgResult)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_MOVIE, movie)
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