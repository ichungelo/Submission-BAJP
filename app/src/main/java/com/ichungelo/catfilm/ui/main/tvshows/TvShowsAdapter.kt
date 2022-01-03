package com.ichungelo.catfilm.ui.main.tvshows

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ichungelo.catfilm.databinding.ItemsPosterBinding
import com.ichungelo.catfilm.model.DataEntity

class TvShowsAdapter: RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {
    private val listTvShows = ArrayList<DataEntity>()

    fun setTvShows(tvShows: List<DataEntity>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }
    class TvShowsViewHolder(private val binding: ItemsPosterBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: DataEntity) {
            with(binding) {
                tvTitlePoster.text = tvShow.title
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val binding = ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val tvShow =listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size
}