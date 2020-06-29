package com.example.sampleapp.fragmentB

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.databinding.SampleItemBinding

class SampleAdapter : androidx.recyclerview.widget.ListAdapter<String, SampleAdapter.SampleViewHolder>(
    SampleDiffUtil
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder {
        return SampleViewHolder(
            SampleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) = holder.bind(getItem(position))

    class SampleViewHolder(private val binding: SampleItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(sampleItem: String) {
            binding.run {
                this.sampleItem = sampleItem
                executePendingBindings()
            }
        }
    }

    object SampleDiffUtil: DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
}