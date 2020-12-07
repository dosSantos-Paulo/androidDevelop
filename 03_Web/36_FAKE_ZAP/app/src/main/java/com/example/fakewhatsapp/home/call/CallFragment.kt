package com.example.fakewhatsapp.home.call

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fakewhatsapp.R
import com.example.fakewhatsapp.model.CharacterModel
import com.example.fakewhatsapp.repository.CharacterRepository
import com.example.fakewhatsapp.viewmodel.CharacterViewModel


class CallFragment : Fragment() {

    private lateinit var _viewMode: CharacterViewModel
    private lateinit var _view : View
    private lateinit var _listaAdapter: CharacterAdapter
    private lateinit var _recyclerView: RecyclerView

    private var _characterList = mutableListOf<CharacterModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_call, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _view = view
        _recyclerView = _view.findViewById(R.id.recyclerView_Calls)

        val manager = LinearLayoutManager(_view.context)

        _characterList = mutableListOf()
        _listaAdapter = CharacterAdapter(_characterList)

        _recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _listaAdapter
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        _viewMode = ViewModelProvider(this, CharacterViewModel.CharacterViewModelFactory(
            CharacterRepository()
        )).get(CharacterViewModel::class.java)

        _viewMode.getList().observe(viewLifecycleOwner, {

        })

    }

}