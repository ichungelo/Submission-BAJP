package com.ichungelo.catfilm.ui.favorite.fragment.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.databinding.ItemsResultBinding
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.utils.Helper

class FavoriteTvShowsAdapter: PagedListAdapter<TvEntity, FavoriteTvShowsAdapter.FavoriteTvShowsViewHolder>(DIFF_CALLBACK) {

    class FavoriteTvShowsViewHolder(private val binding: ItemsResultBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShows: TvEntity) {
            with(binding) {
                tvResultTitle.text = tvShows.title
                tvResultReleraseDate.text = Helper.changeDateFormat(tvShows.releaseDate)
                Helper.imageGlider(itemView.context, tvShows.posterPath, imgResult)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, tvShows)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowsViewHolder {
        val binding = ItemsResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteTvShowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteTvShowsViewHolder, position: Int) {
        val tvShow = getItem(position)
        if (tvShow != null) {
            holder.bind(tvShow)
        }
    }

    companion object {
        private val  DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvEntity>() {
            override fun areItemsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: TvEntity, newItem: TvEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}