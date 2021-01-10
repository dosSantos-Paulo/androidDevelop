package com.devdossantos.myapplication.cartao.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devdossantos.myapplication.R
import com.devdossantos.myapplication.cartao.entity.CartaoEntity
import com.devdossantos.myapplication.cartao.repository.CartaoRepository
import com.devdossantos.myapplication.cartao.viewmodel.CartaoViewModel
import com.devdossantos.myapplication.database.AppDataBase


class CartaoFragment : Fragment() {

    private lateinit var _viewModel: CartaoViewModel
    private lateinit var _view: View


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cartao, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view

        _viewModel = ViewModelProvider(
            this,
            CartaoViewModel.CartaoViewModelFactory(
                CartaoRepository(
                    AppDataBase.getDatabase(view.context).cartaoDao()
                )
            )
        ).get(CartaoViewModel::class.java)

        cadastrarCartao(
            CartaoEntity(
                "0000111122223333",
                "Paulo dos Santos",
                "700",
                "10/2025",
                "master"
            )
        )
    }

    fun cadastrarCartao(cartao: CartaoEntity) {
        _viewModel.addCartao(cartao).observe(viewLifecycleOwner, {
            Log.i("PAGBEM,", it.toString())

            _viewModel.count().observe(viewLifecycleOwner, {
                _view.findViewById<TextView>(R.id.txt_quantidade_cartao).text = it.toString()
            })
        })
    }
}