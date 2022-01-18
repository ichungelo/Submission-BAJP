package com.ichungelo.catfilm.ui.favorite.fragment.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.databinding.ItemsResultBinding
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.utils.Helper
import com.ichungelo.catfilm.utils.MovieDiffCallback

class FavoriteMoviesAdapter: RecyclerView.Adapter<FavoriteMoviesAdapter.FavoriteMoviesViewHolder>() {
    private val listFavoriteMovies = ArrayList<MovieEntity>()

    fun setFavoriteMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        val diffCallback = MovieDiffCallback(this.listFavoriteMovies, movies)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listFavoriteMovies.clear()
        this.listFavoriteMovies.addAll(movies)
        diffResult.dispatchUpdatesTo(this)
    }

    class FavoriteMoviesViewHolder(private val binding: ItemsResultBinding): RecyclerView.ViewHolder(binding.root) {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMoviesViewHolder {
        val binding = ItemsResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteMoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteMoviesViewHolder, position: Int) {
        val movie = listFavoriteMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listFavoriteMovies.size
}