package com.ichungelo.catfilm.ui.main.fragment.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.databinding.ItemsPosterBinding
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.utils.Helper
import com.ichungelo.catfilm.utils.TvShowDiffCallback

class TvShowsAdapter : RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {
    private val listTvShows = ArrayList<TvEntity>()

    fun setTvShows(tvShows: List<TvEntity>?) {
        if (tvShows == null) return
        val diffCallback = TvShowDiffCallback(this.listTvShows,tvShows)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
        diffResult.dispatchUpdatesTo(this)
    }

    class TvShowsViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvEntity) {
            with(binding) {
                tvTitlePoster.text = tvShow.title
                tvYearPoster.text = Helper.getReleaseYear(tvShow.releaseDate)
                Helper.imageGlider(itemView.context, tvShow.posterPath, imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, tvShow)
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