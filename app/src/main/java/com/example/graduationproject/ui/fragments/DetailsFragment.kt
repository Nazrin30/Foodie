package com.example.graduationproject.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.data.entity.Foods
import com.example.graduationproject.data.entity.FoodsInCart
import com.example.graduationproject.databinding.FragmentDetailsBinding
import com.example.graduationproject.ui.viewmodels.DetailsViewModel
import com.example.graduationproject.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel2 : LoginViewModel
    private lateinit var viewModel: DetailsViewModel
    lateinit var foodToAdd: Foods
    var orderAmountCounter: Int = 0
    var amount: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        binding.detailsFragment = this

        val bundle: DetailsFragmentArgs by navArgs()
        val resultFood = bundle.food
        val url = "http://kasimadalan.pe.hu/foods/images/${resultFood.image}"
        Glide.with(this).load(url).into(binding.imageView3)
        binding.food = resultFood
//        binding.goToCart.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.toCart)
//        }
        foodToAdd = resultFood



        Log.e("working", "viewCreate")

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: DetailsViewModel by viewModels()
        viewModel = tempViewModel
        val tempViewModel2 : LoginViewModel by viewModels()
        viewModel2 = tempViewModel2
        Log.e("working", "onCreate")
    }

    fun addToCart(
        name: String,
        image: String,
        price: Int,
        category: String,
        orderAmount: Int,
        userName: String
    ) {
        //var food = FoodsInCart(name, image, price, category, orderAmount, userName)

        viewModel.addToCart(name, image, price, category, orderAmount, userName)
        Log.e(
            "Working2",
            "${name}, ${image} , ${price}, ${category}, ${orderAmount}, ${userName}"
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.e("working", "viewCreated")
        Log.e("works", "works before button")
        try {
            viewModel.getFoodsInCart()

        }catch (e:Exception){}
        viewModel.getFoodsInCart()
        binding.btnAddToCart.setOnClickListener {
            Log.e("works", "works")


            Log.e("works", viewModel.foodsInCart.value.toString())
            if (viewModel.foodsInCart.value != null){
                Log.e("works2", viewModel.foodsInCart.toString())
                viewModel.foodsInCart.observe(viewLifecycleOwner) { list ->

                    list.forEach { foodInCart ->
                        if (foodToAdd.name == foodInCart.name) {
                            orderAmountCounter += foodInCart.orderAmount
                            viewModel.deleteFoodFromCart(foodInCart.cartId, "nazrin")

                        }
                    }

                    addToCart(
                        foodToAdd.name,
                        foodToAdd.image,
                        foodToAdd.price,
                        foodToAdd.category,
                        orderAmountCounter + amount,
                        "nazrin"
                    )
                }

            }else{
                addToCart(foodToAdd.name, foodToAdd.image, foodToAdd.price, foodToAdd.category, amount, "nazrin")
            }



        }
        binding.orderAmountVar = amount
        binding.btnAdd.setOnClickListener {
            amount += 1
            binding.orderAmount.text = amount.toString()
            binding.orderAmountVar = amount

        }
        binding.btnRemove.setOnClickListener {
            if (orderAmountCounter > 1) {
                amount += 1
                binding.orderAmount.text = amount.toString()
                binding.orderAmountVar = amount
            }
        }
    }

    override fun onPause() {
        super.onPause()

    }
}