package com.dossantosp.lab22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import layout.Usuario

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//
//        Picasso.get().load("../../main/res/mipmap-xxxhdpi/ic_cap.png").into(img_FotoMensagem)


        val usuario1 = Usuario(R.mipmap.ic_cap,"Captão", "Hey Garoto, quando virá buscar o escudo ?", "17:45")
        val usuario2 = Usuario(R.mipmap.ic_hulk,"Professor H.", "Você perdeu a ultima aula de aritimética avançada", "16:00")
        val usuario3 = Usuario(R.mipmap.ic_iron, "Tony", "Amanhã te pago!!!", "12:45")


        val viewManager = LinearLayoutManager(this)
        val recycleView = findViewById<RecyclerView>(R.id.minhaLista)
        val viewAdapter = MeuAdapter(arrayListOf(usuario1, usuario2, usuario3))

        recycleView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter

            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

    }
}