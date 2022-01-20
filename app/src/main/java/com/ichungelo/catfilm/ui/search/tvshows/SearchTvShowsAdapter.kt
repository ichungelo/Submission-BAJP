package com.ichungelo.catfilm.ui.search.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.databinding.ItemsResultBinding
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.utils.Helper
import com.ichungelo.catfilm.utils.TvShowDiffCallback


class SearchTvShowsAdapter : RecyclerView.Adapter<SearchTvShowsAdapter.SearchTvShowsViewHolder>() {
    private val listSearchTvShows = ArrayList<TvEntity>()

    fun setSearchTvShows(tvShows: List<TvEntity>?) {
        if (tvShows == null) return
        val diffCallback = TvShowDiffCallback(this.listSearchTvShows, tvShows)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listSearchTvShows.clear()
        this.listSearchTvShows.addAll(tvShows)
        diffResult.dispatchUpdatesTo(this)
    }

    class SearchTvShowsViewHolder(private val binding: ItemsResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvEntity) {
            with(binding) {
                tvResultTitle.text = tvShow.title
                tvResultReleraseDate.text = Helper.changeDateFormat(tvShow.releaseDate)
                Helper.imageGlider(itemView.context, tvShow.posterPath, imgResult)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, tvShow)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchTvShowsViewHolder {
        val binding = ItemsResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchTvShowsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SearchTvShowsViewHolder, position: Int) {
        val movie = listSearchTvShows[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listSearchTvShows.size
}