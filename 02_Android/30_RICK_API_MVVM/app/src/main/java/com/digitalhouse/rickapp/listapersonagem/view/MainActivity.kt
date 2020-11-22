package com.digitalhouse.rickapp.listapersonagem.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.digitalhouse.rickapp.R
import com.digitalhouse.rickapp.listapersonagem.model.Personagem
import com.digitalhouse.rickapp.listapersonagem.repository.ListaPersonagemRepository
import com.digitalhouse.rickapp.listapersonagem.viewmodel.ListaPersonagemViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ListaPersonagemViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(
            this,
            ListaPersonagemViewModel.ListaPersonagemViewModelFactory(ListaPersonagemRepository(this))
        ).get(ListaPersonagemViewModel::class.java)

        viewModel.personagem.observe(this, Observer{
            criarLista(it)
        })

        viewModel.obterLista()

        }

    fun criarLista(personagens: List<Personagem>) {
        val viewManager = GridLayoutManager(this, 2)
        val recyclerView = findViewById<RecyclerView>(R.id.recycle_RickList)

        val viewAdapter = RecyclerAdapter(personagens) {

            val alertaDialog = MaterialAlertDialogBuilder(this@MainActivity,
                R.style.Apptheme2
            )
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
}



