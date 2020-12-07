package com.example.fakewhatsapp.home.call

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fakewhatsapp.R
import com.example.fakewhatsapp.model.CharacterModel

class CharacterAdapter(
    private val _dataSet: List<CharacterModel>
) : RecyclerView.Adapter<CharacterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_call,
            parent,
            false
        )
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = _dataSet[position]
        holder.bind(item)
    }

    override fun getItemCount() = _dataSet.size
}