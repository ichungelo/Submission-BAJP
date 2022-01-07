package com.ichungelo.catfilm.ui.main.fragment

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ichungelo.catfilm.databinding.ItemsPosterBinding
import com.ichungelo.catfilm.model.DataEntity
import com.ichungelo.catfilm.ui.detail.DetailActivity

class DataAdapter : RecyclerView.Adapter<DataAdapter.DataViewHolder>() {
    private val listData = ArrayList<DataEntity>()

    fun setData(movies: List<DataEntity>?) {
        if (movies == null) return
        this.listData.clear()
        this.listData.addAll(movies)
    }

    class DataViewHolder(private val binding: ItemsPosterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: DataEntity) {
            with(binding) {
                tvTitlePoster.text = data.title
                Glide.with(itemView.context)
                    .load(data.poster)
                    .into(imgPoster)
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, data.dataId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = ItemsPosterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val movie = listData[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listData.size
}