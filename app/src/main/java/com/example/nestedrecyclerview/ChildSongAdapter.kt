package com.example.nestedrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ItemChildSongBinding

class ChildSongAdapter: ListAdapter<Song, RecyclerView.ViewHolder>(SOngDiffCallback()) {

    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemChildSongBinding.bind(view)
    }

    class SOngDiffCallback : DiffUtil.ItemCallback<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song) = oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Song, newItem: Song) = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_child_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val song = getItem(position)

        with(holder as ViewHolder){
            binding.tvChildName.text = song.name
            binding.containerMain.setBackgroundColor(ContextCompat.getColor(context, song.color))
        }
    }
}
