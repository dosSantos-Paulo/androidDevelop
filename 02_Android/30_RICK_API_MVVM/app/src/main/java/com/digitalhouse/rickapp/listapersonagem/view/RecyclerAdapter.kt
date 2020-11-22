package com.digitalhouse.rickapp.listapersonagem.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.R
import com.digitalhouse.rickapp.listapersonagem.model.Personagem
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val dataSet: List<Personagem>,
                      private val listener: (Personagem) -> Unit): RecyclerView.Adapter<RecyclerAdapter.meuViewHolder>() {

    class meuViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val image: ImageView = view.findViewById(R.id.img_itemImage)
        private val name: TextView = view.findViewById(R.id.txt_itemName)

        fun bind (person: Personagem) {

            Picasso.get().load(person.imagemUrl).into(image)
            name.text = person.nome
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): meuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return meuViewHolder(view)
    }

    override fun getItemCount() = dataSet.size


    override fun onBindViewHolder(holder: meuViewHolder, position: Int) {
        val item = dataSet[position]
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener { listener(item) }
    }
}

