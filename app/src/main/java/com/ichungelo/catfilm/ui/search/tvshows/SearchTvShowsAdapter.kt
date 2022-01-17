package com.ichungelo.catfilm.ui.search.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.data.DataEntity
import com.ichungelo.catfilm.databinding.ItemsResultBinding
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.ui.detail.DetailViewModel
import com.ichungelo.catfilm.utils.DiffCallback
import com.ichungelo.catfilm.utils.Helper


class SearchTvShowsAdapter : RecyclerView.Adapter<SearchTvShowsAdapter.SearchTvShowsViewHolder>() {
    private val listSearchTvShows = ArrayList<DataEntity>()

    fun setSearchTvShows(tvShows: List<DataEntity>?) {
        if (tvShows == null) return
        val diffCallback = DiffCallback(this.listSearchTvShows, tvShows)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listSearchTvShows.clear()
        this.listSearchTvShows.addAll(tvShows)
        diffResult.dispatchUpdatesTo(this)
    }

    class SearchTvShowsViewHolder(private val binding: ItemsResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: DataEntity) {
            with(binding) {
                tvResultTitle.text = tvShow.title
                tvResultReleraseDate.text = Helper.changeDateFormat(tvShow.releaseDate)
                Helper.imageGlider(itemView.context, tvShow.posterPath, imgResult)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, tvShow)
                    intent.putExtra(DetailActivity.EXTRA_CATEGORY, DetailViewModel.TV_SHOW)
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