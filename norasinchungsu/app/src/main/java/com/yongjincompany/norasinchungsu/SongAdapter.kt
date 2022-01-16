package com.yongjincompany.norasinchungsu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.norasinchungsu.data.remote.model.SongListResponse
import com.yongjincompany.norasinchungsu.databinding.ItemListBinding

class SongAdapter : RecyclerView.Adapter<SongAdapter.SongViewHolder>() {

    inner class SongViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<SongListResponse>() {
        override fun areItemsTheSame(oldItem: SongListResponse, newItem: SongListResponse): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SongListResponse, newItem: SongListResponse): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var songs: List<SongListResponse>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun getItemCount() = songs.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        return SongViewHolder(
            ItemListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ))
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.binding.apply {
            val song = songs[position]
            title.text = song.text
        }
    }
}