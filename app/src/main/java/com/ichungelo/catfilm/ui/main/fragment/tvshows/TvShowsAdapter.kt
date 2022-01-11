package com.ichungelo.catfilm.ui.main.fragment.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ichungelo.catfilm.BuildConfig
import com.ichungelo.catfilm.databinding.ItemsPosterBinding
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.ui.detail.DetailViewModel.Companion.TV_SHOW

class TvShowsAdapter : RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {
    private val listTvShows = ArrayList<DataEntity>()

    fun setTvShows(tvShows: List<DataEntity>?) {
        if (tvShows == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
    }

    class TvShowsViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: DataEntity) {
            with(binding) {
                tvTitlePoster.text = tvShow.title
                Glide.with(itemView.context)
                    .load( "${BuildConfig.IMAGE_URL}t/p/w500${tvShow.posterPath}")
                    .into(imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, tvShow)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY,TV_SHOW)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowsViewHolder {
        val binding = ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowsViewHolder, position: Int) {
        val movie = listTvShows[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listTvShows.size
}