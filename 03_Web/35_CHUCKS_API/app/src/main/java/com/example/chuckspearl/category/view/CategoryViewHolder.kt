package com.example.chuckspearl.category.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chuckspearl.R
import com.google.android.material.button.MaterialButton

class CategoryViewHolder (
    private val _view: View
): RecyclerView.ViewHolder(_view) {
    private val _boxCategory = _view.findViewById<TextView>(R.id.txt_categoryName_box)

    fun bind(category: String) {
        _boxCategory.text = category.capitalize()
    }
}
