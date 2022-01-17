package com.ichungelo.catfilm.ui.main.fragment.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ichungelo.catfilm.BuildConfig
import com.ichungelo.catfilm.R
import com.ichungelo.catfilm.databinding.ItemsPosterBinding
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.ui.detail.DetailViewModel.Companion.TV_SHOW
import com.ichungelo.catfilm.utils.DiffCallback
import com.ichungelo.catfilm.utils.Helper

class TvShowsAdapter : RecyclerView.Adapter<TvShowsAdapter.TvShowsViewHolder>() {
    private val listTvShows = ArrayList<DataEntity>()

    fun setTvShows(tvShows: List<DataEntity>?) {
        if (tvShows == null) return
        val diffCallback = DiffCallback(this.listTvShows,tvShows)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShows)
        diffResult.dispatchUpdatesTo(this)
    }

    class TvShowsViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: DataEntity) {
            with(binding) {
                tvTitlePoster.text = tvShow.title
                Helper.imageGlider(itemView.context, tvShow.posterPath, imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, tvShow)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, TV_SHOW)
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