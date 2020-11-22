package com.dossantosp.lab24

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class MeuFragment : Fragment() {

    private var nome: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

            nome = it.getString("TEXTO")



        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meu, container, false)

        view.findViewById<TextView>(R.id.txt_meuTexto_fragment).text = nome
        return view
    }

    companion object {

        fun newInstance(texto:String) =
            MeuFragment().apply {
                arguments = Bundle().apply {
                    putString("TEXTO", texto)
                }
            }
    }
}