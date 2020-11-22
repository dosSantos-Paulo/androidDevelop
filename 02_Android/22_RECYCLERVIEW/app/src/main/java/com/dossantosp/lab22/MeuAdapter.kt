package com.dossantosp.lab22

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import layout.Usuario
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import org.w3c.dom.Text

class MeuAdapter( private val dataSet: List<Usuario> ): RecyclerView.Adapter<MeuAdapter.meuViewHolder>() {

    class meuViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.img_FotoMensagem)
        private val nome: TextView = view.findViewById(R.id.txt_NomeMensagem)
        private val resumo: TextView = view.findViewById(R.id.txt_resumoMensagem)
        private val hora: TextView = view.findViewById(R.id.txt_horaMensagem)

        fun bind(user: Usuario) {

            Picasso.get().load(user.imageUrl).into(image)
            nome.text = user.nome
            resumo.text = user.ultimaMensagem
            hora.text = user.hora
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): meuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.intem_lista, parent, false)

        return meuViewHolder(view)
    }

    override fun getItemCount() = dataSet.size


    override fun onBindViewHolder(holder: meuViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

}


