package com.example.sampleapp.fragmentA

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.databinding.HomeItemBinding
import com.example.sampleapp.model.Sample

class HomeAdapter(private val listener: HomeAdapterListener) : ListAdapter<Sample, HomeAdapter.HomeViewHolder>(HomeDiffUtil) {

    interface HomeAdapterListener {
        fun onHomeItemClick(cardView: View, position: Int) {}
    }

    class HomeViewHolder(private val binding: HomeItemBinding, private val listener: HomeAdapterListener): RecyclerView.ViewHolder(binding.root) {

        fun bind(sampleItem: Sample, position: Int) {
            binding.run {
                this.sampleItem = sampleItem
                this.position = position
                this.listener = this@HomeViewHolder.listener
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            HomeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            listener
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) = holder.bind(getItem(position), position)

    object HomeDiffUtil: DiffUtil.ItemCallback<Sample>() {
        override fun areItemsTheSame(oldItem: Sample, newItem: Sample): Boolean {
            return true
        }

        override fun areContentsTheSame(oldItem: Sample, newItem: Sample): Boolean {
            return true
        }
    }
}