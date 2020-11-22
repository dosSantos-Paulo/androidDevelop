package com.example.chuckspearl.joke.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chuckspearl.R
import com.example.chuckspearl.category.view.CategoriesFragment.Companion.CATEGORY_KEY
import com.example.chuckspearl.joke.model.JokeModel
import com.example.chuckspearl.joke.repository.JokeRepository
import com.example.chuckspearl.joke.viewmodel.JokeViewModel
import com.squareup.picasso.Picasso

class JokeFragment : Fragment() {

    private lateinit var _viewModel: JokeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_joke, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = arguments?.getString(CATEGORY_KEY)

        _viewModel = ViewModelProvider(
            this,
            JokeViewModel.JokeViewModelFactory(
                JokeRepository()
            )
        ).get(JokeViewModel::class.java)


        _viewModel.getNewJoke(category!!).observe(viewLifecycleOwner, {
            showResult(view, it)
        })

    }

    private fun showResult(view: View, it: JokeModel) {
        val icon = view.findViewById<ImageView>(R.id.img_jokeIcon_jokeFragment)
        val joke = view.findViewById<TextView>(R.id.txt_joke_jokeFragment)

        joke.text = it.value

        Picasso.get().load(it.icon).into(icon)
    }
}