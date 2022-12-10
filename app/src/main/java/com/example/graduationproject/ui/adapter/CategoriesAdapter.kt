package com.example.graduationproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsInCart
import com.example.graduationproject.databinding.CategoriesCardDesignBinding
import com.example.graduationproject.ui.fragments.HomeFragment
import com.example.graduationproject.ui.viewmodels.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesAdapter(var mContext: Context, var categoriesList: List<String>, var viewModel: HomeViewModel)

    :RecyclerView.Adapter<CategoriesAdapter.CategoriesCardDesignHolder>()
{

    inner class CategoriesCardDesignHolder (var binding: CategoriesCardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesCardDesignHolder {
        var binding : CategoriesCardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.categories_card_design, parent, false)
        return CategoriesCardDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesCardDesignHolder, position: Int) {
        var category = categoriesList.get(position)
        var b = holder.binding
        Log.e("category", category)
        b.categoriesFilter.text = category
        if (category == "Meals"){
            b.categoriesImage.setImageResource(R.drawable.meals_ic)
        }else if (category == "Drinks"){
            b.categoriesImage.setImageResource(R.drawable.drinks_ic)
        }else if (category == "Desserts"){
            b.categoriesImage.setImageResource(R.drawable.desserts_ic)
        }else{
            b.categoriesImage.setImageResource(R.drawable.all_foods_ic)
        }
        b.categoriesCard.setOnClickListener {

            viewModel.categoriesFilter(category)
        }


    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }
}