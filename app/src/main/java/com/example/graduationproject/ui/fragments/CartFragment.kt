package com.example.graduationproject.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentCartBinding
import com.example.graduationproject.ui.adapter.CartItemAdapter
import com.example.graduationproject.ui.viewmodels.CartViewModel
import com.example.graduationproject.ui.viewmodels.HomeViewModel
import com.example.graduationproject.ui.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel
    private lateinit var viewModel2 : LoginViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cart, container, false)
        binding.cartFragment = this

        //binding.textView4.text = "Good Choise!"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: CartViewModel by viewModels()
        viewModel = tempViewModel
        val tempViewModel2 : LoginViewModel by viewModels()
        viewModel2 = tempViewModel2
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        try {
            binding.cartRV.layoutManager = LinearLayoutManager(context)
            viewModel.foodsInCart.observe(viewLifecycleOwner){
                val adapter = CartItemAdapter(requireContext(), it, viewModel, viewModel2)
                binding.adapter = adapter
                viewModel.calculateTotal()
            }.run {
                val adapter = CartItemAdapter(requireContext(), arrayListOf(), viewModel, viewModel2)
                binding.adapter = adapter
            }

        }catch (e:Exception){}

         viewModel.getTotalPrice().observe(viewLifecycleOwner){
             binding.totalText.text =  viewModel.getTotalPrice().value.toString()+"$"
         }

    }

    override fun onResume() {
        super.onResume()
        viewModel.loadFoodsInCart("nazrin")
        viewModel.calculateTotal()
    }

}