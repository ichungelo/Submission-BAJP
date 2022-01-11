package com.ichungelo.catfilm.ui.main.fragment.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ichungelo.catfilm.BuildConfig
import com.ichungelo.catfilm.databinding.ItemsPosterBinding
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.ui.detail.DetailViewModel.Companion.MOVIE

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private val listMovies = ArrayList<DataEntity>()

    fun setMovies(movies: List<DataEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    class MoviesViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataEntity) {
            with(binding) {
                tvTitlePoster.text = movie.title
                Glide.with(itemView.context)
                    .load( "${BuildConfig.IMAGE_URL}t/p/w500${movie.posterPath}")
                    .into(imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, movie)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY,MOVIE)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding = ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size
}