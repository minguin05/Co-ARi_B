package com.cse.coari.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cse.coari.databinding.ItemSwipeBinding
import com.google.android.material.snackbar.Snackbar

class SwipeListAdapter : RecyclerView.Adapter<SwipeListAdapter.SwipeViewHolder>() {
    private val items: MutableList<String> = mutableListOf<String>().apply {
        for (i in 0..10)
            add("$i")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SwipeViewHolder = SwipeViewHolder(
        ItemSwipeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: SwipeViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class SwipeViewHolder(private val binding: ItemSwipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(label: String) {
            binding.label = label
            // 테스크 버튼 클릭시 SnackBar 표시
            binding.task.setOnClickListener {
                Snackbar.make(it, "$label click", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}