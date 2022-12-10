package com.example.graduationproject.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.databinding.FragmentHomeBinding
import com.example.graduationproject.ui.adapter.CategoriesAdapter
import com.example.graduationproject.ui.adapter.FoodsAdapter
import com.example.graduationproject.ui.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeFragment = this
        binding.foodsRV.layoutManager = GridLayoutManager(context, 2)
        binding.foodsRV.setHasFixedSize(false)
//        binding.searchView.setOnClickListener(View.OnClickListener })
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }
        }
        )
        viewModel.filteredFoodsList.observe(viewLifecycleOwner) {
            val adapter = FoodsAdapter(requireContext(), it)
            binding.adapter = adapter

        }
        var categoriesList = ArrayList<String>()
        categoriesList.add("All")
        categoriesList.add("Meals")
        categoriesList.add("Desserts")
        categoriesList.add("Drinks")


        //Log.e("tempfoods", viewModel.tempfoods.toString())
//        for (i in 0..tempfoods!!.size-1){
//            var category = tempfoods[i].category
//            Log.e("category", category)
////            if (!categoriesList.contains(category)){
////                categoriesList.add(category)
////            }
//
//        }
//        Log.e("categories", categoriesList.toString())
        binding.categoriesRV.layoutManager = GridLayoutManager(context,4)
        val categoriesAdapter = CategoriesAdapter(requireContext(),categoriesList, viewModel)
        binding.categoriesAdapter = categoriesAdapter

    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFoods()
        //Return to HomeFragment and reload persons
    }



}