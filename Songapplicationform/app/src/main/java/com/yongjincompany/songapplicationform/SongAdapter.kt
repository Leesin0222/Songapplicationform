package com.yongjincompany.songapplicationform

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yongjincompany.songapplicationform.data.RecieveSongResponseDTO
import kotlinx.android.synthetic.main.item_list.view.*


class SongAdapter(private val songs: List<RecieveSongResponseDTO>) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount() = songs.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = songs[position]
        holder.songtitle.text = song.text
        holder.songid.text = song.id
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val songtitle: TextView = itemView.title
        val songid: TextView = itemView.sequence
    }

}