package com.example.graduationproject.ui.fragments

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentHomeBinding
import com.example.graduationproject.databinding.FragmentLoginBinding
import com.example.graduationproject.ui.viewmodels.HomeViewModel

import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       binding = FragmentLoginBinding.inflate(inflater, container,false)
       auth = Firebase.auth
       binding.goToRegister.setOnClickListener{
           Navigation.findNavController(it).navigate(LoginFragmentDirections.actionLoginFragment2ToRegisterFragment2())
       }
        binding.button.setOnClickListener { view ->
            val email = binding.usernameText.text.toString()
            val password = binding.passwordText.text.toString()

            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {

               // var username = viewModel.username.value
                Navigation.findNavController(view).navigate(LoginFragmentDirections.toHome2())
            }.addOnFailureListener {
                Snackbar.make(requireView(), "Login process failed", Snackbar.LENGTH_SHORT).show()
            }

           //Navigation.findNavController(it).navigate(LoginFragmentDirections.toRegister())
        }
        return binding.root
    }


}