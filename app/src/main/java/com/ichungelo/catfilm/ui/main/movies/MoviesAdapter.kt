package com.ichungelo.catfilm.ui.main.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ichungelo.catfilm.databinding.ItemsPosterBinding
import com.ichungelo.catfilm.model.DataEntity

class MoviesAdapter: RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private val listMovies = ArrayList<DataEntity>()

    fun setMovies(movies: List<DataEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }
    class MoviesViewHolder(private val binding: ItemsPosterBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: DataEntity) {
            with(binding) {
                tvTitlePoster.text = movie.title
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val binding =ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie =listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size
}