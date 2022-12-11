package com.example.graduationproject.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsInCart
import com.example.graduationproject.databinding.CartItemDesignBinding
import com.example.graduationproject.ui.viewmodels.CartViewModel


class CartItemAdapter (var mContext: Context, var foodsInCartList : List<FoodsInCart>, var viewModel: CartViewModel,
                      )
    :RecyclerView.Adapter<CartItemAdapter.CartItemDesignHolder>()
{

    inner class CartItemDesignHolder ( var binding : CartItemDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemDesignHolder {
        var binding : CartItemDesignBinding  = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.cart_item_design,
            parent, false )
        return CartItemDesignHolder(binding)
    }

    override fun onBindViewHolder(holder: CartItemDesignHolder, position: Int) {

        var foodInCart = foodsInCartList.get(position)
        var b = holder.binding
        holder.binding.foodsInCart = foodInCart
//         b.cardItemName.text = foodInCart.name
//        b.cardItemPrice.text = foodInCart.price.toString()
        Log.i("test", "onBindViewHolder: ${foodInCart.price}")
        val url = "http://kasimadalan.pe.hu/foods/images/${foodInCart.image}"
        Glide.with(mContext).load(url).into(b.imageView4)

        b.btnDelete.setOnClickListener {
            viewModel.deleteFoodInCart(foodInCart.cartId, foodInCart.userName)
        }

        //viewModel.totalAmount += b.cardItemPrice.text.toString().toInt()
        var orderAmount = foodInCart.orderAmount ?: 0
        b.orderAmountVar = orderAmount
        b.btnAdd.setOnClickListener {
            orderAmount += 1
            b.orderAmount.text = orderAmount.toString()
            b.orderAmountVar = orderAmount
//            viewModel.increaseAmountInCart(foodInCart.name, foodInCart.image, foodInCart.price,
//                foodInCart.category, orderAmount, "nazrin")

        }
        b.btnRemove.setOnClickListener {
            if (orderAmount > 1){
                orderAmount -= 1
                b.orderAmount.text = orderAmount.toString()
                b.orderAmountVar = orderAmount
//                viewModel.deleteFoodInCart(foodInCart.cartId, foodInCart.userName)
            }
        }
    }

    override fun getItemCount(): Int {
        return foodsInCartList.size
    }
}