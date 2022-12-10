package com.example.graduationproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentAccountBinding


class AccountFragment : Fragment() {
    private lateinit var binding : FragmentAccountBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        binding.button3.setOnClickListener{
            Navigation.findNavController(it).navigate(AccountFragmentDirections.signOut())
        }
        return binding.root
    }


}