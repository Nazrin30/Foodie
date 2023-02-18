package com.example.graduationproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.databinding.CardDesignBinding
import com.example.graduationproject.ui.fragments.HomeFragment
import com.example.graduationproject.ui.fragments.HomeFragmentDirections
import com.example.graduationproject.ui.viewmodels.HomeViewModel

class FoodsAdapter (var mContext: Context, var foodsList: List<Foods>)
    : RecyclerView.Adapter<FoodsAdapter.CardDesignHolder>() {

    inner class CardDesignHolder (var binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding : CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_design, parent, false)
        return CardDesignHolder(binding)

    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val food = foodsList.get(position)
        Log.e("Working", food.toString())
        val b = holder.binding
        b.food = food

        b.btnToDetails.setOnClickListener {
            Navigation.findNavController(it).navigate(HomeFragmentDirections.toDetails(food = food))
        }

        val url = "http://kasimadalan.pe.hu/foods/images/${food.image}"
        Log.e("Food image", url)
        Glide.with(mContext).load(url).into(b.foodImage)
    }

    override fun getItemCount(): Int {
        Log.e("Working" ,"${foodsList.size}")
        return foodsList.size
    }
}