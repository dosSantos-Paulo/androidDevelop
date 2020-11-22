package com.digitalhouse.rickapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.api.IRespostaDaApi
import com.digitalhouse.rickapp.api.Personagem
import com.digitalhouse.rickapp.api.RickApi
import com.squareup.picasso.Picasso
import layout.RecyclerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = LinearLayoutManager(this)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_RickList)


        RickApi.getData(this, object: IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {
//
//                Picasso.get()
//                    .load(personagens[0].imagemUrl)
//                    .into()

                val viewAdapter = RecyclerAdapter(personagens)

                recyclerView.apply {
                    layoutManager = viewManager
                    adapter = viewAdapter
                }


            }
        })
    }
}