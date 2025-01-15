package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentLoginBinding
import com.example.anmp_creppybalado_project.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.loginSuccessLD.observe(viewLifecycleOwner, { success ->
            if (success) {
                findNavController().navigate(R.id.action_login_to_home)
            }
        })

        viewModel.loginErrorLD.observe(viewLifecycleOwner, { error ->
            if (error) {
                Toast.makeText(requireContext(), "Login failed. Please check your username and password.", Toast.LENGTH_SHORT).show()
            }
        })

        binding.btnSignUp.setOnClickListener {
            // Arahkan ke RegisterFragment
            findNavController().navigate(R.id.action_login_to_register)
        }

        viewModel.navigateToLogin.observe(viewLifecycleOwner, { shouldNavigate ->
            if (shouldNavigate) {
                findNavController().navigate(R.id.loginFragment)
            }
        })
    }

}