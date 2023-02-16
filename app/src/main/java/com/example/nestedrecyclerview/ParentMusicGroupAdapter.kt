package com.example.nestedrecyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ItemParentMusicGroupBinding

class ParentMusicGroupAdapter : ListAdapter<MusicGroup, RecyclerView.ViewHolder>(MusicGroupDiffCallback()) {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_parent_music_group, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val musicGroup = getItem(position)

        with(holder as ViewHolder){
            binding.tvParentName.text = musicGroup.name
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemParentMusicGroupBinding.bind(view)
    }

    class MusicGroupDiffCallback : DiffUtil.ItemCallback<MusicGroup>(){
        override fun areItemsTheSame(oldItem: MusicGroup, newItem: MusicGroup) = oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: MusicGroup, newItem: MusicGroup) = oldItem == newItem

    }


}