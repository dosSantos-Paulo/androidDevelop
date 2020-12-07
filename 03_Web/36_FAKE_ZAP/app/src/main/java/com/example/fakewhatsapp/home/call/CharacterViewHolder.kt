package com.example.fakewhatsapp.home.call

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fakewhatsapp.R
import com.example.fakewhatsapp.model.CharacterModel
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class CharacterViewHolder(
    view: View
): RecyclerView.ViewHolder(view){

    private val _image = view.findViewById<ImageView>(R.id.imgCall)
    private val _name = view.findViewById<TextView>(R.id.txtCallName)
    private val _date = view.findViewById<TextView>(R.id.txtCallDate)

    fun bind (char: CharacterModel) {
        _name.text = char.nickname
        _date.text = char.birthday

        Picasso.get().load(char.img).into(_image)

    }

}
