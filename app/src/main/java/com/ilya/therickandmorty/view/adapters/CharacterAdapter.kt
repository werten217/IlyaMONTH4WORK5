package com.ilya.therickandmorty.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.ilya.therickandmorty.model.model.CharacterResponse
import com.sultan.therickandmorty.databinding.CharacterHolderBinding

class CharacterAdapter() : ListAdapter<CharacterResponse.Result, CharacterAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(CharacterHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    class ViewHolder(val binding : CharacterHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(characterResponse: CharacterResponse.Result) {
            Glide.with(binding.image).load(characterResponse.image).into(binding.image)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CharacterResponse.Result>() {
        override fun areItemsTheSame(oldItem: CharacterResponse.Result, newItem: CharacterResponse.Result): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CharacterResponse.Result, newItem: CharacterResponse.Result): Boolean {
            return oldItem == newItem
        }
    }
}