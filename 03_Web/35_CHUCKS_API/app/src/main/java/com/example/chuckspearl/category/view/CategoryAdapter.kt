package com.example.chuckspearl.category.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.chuckspearl.R

class CategoryAdapter(
    private val _categories: MutableList<String>,
    private val _listener: (String) -> Unit
): RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.category_box,
            parent,
            false
        )
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = _categories[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { _listener(item) }
    }

    override fun getItemCount() = _categories.size


}