package com.ichungelo.catfilm.ui.favorite.fragment.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ichungelo.catfilm.data.source.local.entity.TvEntity
import com.ichungelo.catfilm.databinding.ItemsResultBinding
import com.ichungelo.catfilm.ui.detail.DetailActivity
import com.ichungelo.catfilm.ui.favorite.fragment.movies.FavoriteMoviesAdapter
import com.ichungelo.catfilm.utils.Helper
import com.ichungelo.catfilm.utils.MovieDiffCallback
import com.ichungelo.catfilm.utils.TvShowDiffCallback

class FavoriteTvShowsAdapter: RecyclerView.Adapter<FavoriteTvShowsAdapter.FavoriteTvShowsViewHolder>() {
    private val listFavoriteTvShows = ArrayList<TvEntity>()

    fun setFavoriteTvShows(tvShows: List<TvEntity>?) {
        if (tvShows == null) return
        val diffCallback = TvShowDiffCallback(this.listFavoriteTvShows, tvShows)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listFavoriteTvShows.clear()
        this.listFavoriteTvShows.addAll(tvShows)
        diffResult.dispatchUpdatesTo(this)
    }

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
        val tvShow = listFavoriteTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listFavoriteTvShows.size
}