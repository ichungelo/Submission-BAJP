package com.ichungelo.catfilm.ui.favorite.fragment.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.data.source.local.entity.MovieEntity
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.databinding.ItemsResultBinding
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.utils.Helper
import com.ichungelo.catfilm.utils.MovieDiffCallback

class FavoriteMoviesAdapter: PagedListAdapter<MovieEntity, FavoriteMoviesAdapter.FavoriteMoviesViewHolder>(DIFF_CALLBACK) {

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
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    companion object {
        private val  DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}