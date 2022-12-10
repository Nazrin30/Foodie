package com.example.graduationproject.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.graduationproject.R
import com.example.graduationproject.databinding.FragmentRegisterBinding
import com.example.graduationproject.ui.viewmodels.RegisterViewModel
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private lateinit var auth : FirebaseAuth
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel : RegisterViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater, container, false)

        auth = Firebase.auth

        binding.goToLogin.setOnClickListener{
            Navigation.findNavController(it).navigate(RegisterFragmentDirections.actionRegisterFragment2ToLoginFragment2())
        }

        binding.btnRegister.setOnClickListener {view->
            val email = binding.emailTextRegister.text.toString()
            val password = binding.passwordTextRegister.text.toString()
            val username = binding.usernameText5.text.toString()
            auth.createUserWithEmailAndPassword(email, password)
                .addOnSuccessListener {
                   viewModel.saveUser(username, email, password)
                    Navigation.findNavController(view).navigate(RegisterFragmentDirections.actionRegisterFragment2ToLoginFragment2())
            }.addOnFailureListener{
                  Snackbar.make(requireView(), "Registration process failerd", Snackbar.LENGTH_SHORT).show()
                }

           // Navigation.findNavController(it).navigate(RegisterFragmentDirections.toHome())
        }
        return binding.root

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: RegisterViewModel by viewModels()
        viewModel = tempViewModel
    }

}