package com.digitalhouse.rickapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.digitalhouse.rickapp.api.IRespostaDaApi
import com.digitalhouse.rickapp.api.Personagem
import com.digitalhouse.rickapp.api.RickApi
import layout.RecyclerAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewManager = GridLayoutManager(this, 2)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_RickList)

        RickApi.getData(this, object : IRespostaDaApi {
            override fun obtevePersonagens(personagens: List<Personagem>) {

                val viewAdapter = RecyclerAdapter(personagens) {

                    val alertaDialog = MaterialAlertDialogBuilder(this@MainActivity, R.style.Apptheme2)
                    val layoutView = layoutInflater.inflate(R.layout.full_card_alert, null)

                    layoutView.findViewById<TextView>(R.id.txt_itemName_onFullCard).text = it.nome
                    layoutView.findViewById<TextView>(R.id.txt_itemGenere_onFullCard).text = it.genero
                    layoutView.findViewById<TextView>(R.id.txt_itemPlanet_onFullCard).text = it.localizacao.nome
                    layoutView.findViewById<TextView>(R.id.txt_itemStatus_onFullCard).text = it.status
                    layoutView.findViewById<TextView>(R.id.txt_itemSpecie_onFullCard).text = it.especie
                    Picasso.get().load(it.imagemUrl).into(layoutView.findViewById<ImageView>(R.id.img_itemImage_onFullCard))

                    alertaDialog.apply {
                        setView(layoutView)
                        show()
                    }


                }

                recyclerView.apply {
                    layoutManager = viewManager
                    adapter = viewAdapter

                }
            }
        })
    }
}



