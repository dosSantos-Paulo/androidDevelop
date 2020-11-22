package com.example.chuckspearl.category.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chuckspearl.R
import com.example.chuckspearl.category.repository.CategoryRepository
import com.example.chuckspearl.category.viewmodel.CategoryViewModel

class CategoriesFragment : Fragment() {

    private lateinit var _viewModel: CategoryViewModel
    private lateinit var _categoryAdapter: CategoryAdapter
    private var _categoryList = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navControler = Navigation.findNavController(view)
        val categoriesRecycler = view.findViewById<RecyclerView>(R.id.recyclerView_mainFragment)
        val manager = GridLayoutManager (view.context, LAYOUT_MANAGER_COLUMNS)

        _categoryList = mutableListOf<String>()
        _categoryAdapter = CategoryAdapter(_categoryList) {
            val bundle = bundleOf(CATEGORY_KEY to it)
            navControler.navigate(R.id.action_mainFragment_to_jokeFragment, bundle)
        }


        categoriesRecycler.apply {
            setHasFixedSize(true)
            layoutManager = manager
            adapter = _categoryAdapter
        }

        _viewModel = ViewModelProvider(
            this,
            CategoryViewModel.CategoryViewModelFactory(CategoryRepository())
        ).get(CategoryViewModel::class.java)

        _viewModel.getCategories().observe(viewLifecycleOwner, {
            _categoryList.addAll(it)
            _categoryAdapter.notifyDataSetChanged()
        })

    }

    companion object {
        const val LAYOUT_MANAGER_COLUMNS = 1
        const val CATEGORY_KEY = "CATEGORY"
    }

}
