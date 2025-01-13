package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
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
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)

        viewModel.loginSuccessLD.observe(viewLifecycleOwner, { success ->
            if (success) {
//                navigateToHomeFragment()
            }
        })

        viewModel.loginErrorLD.observe(viewLifecycleOwner, { error ->
            if (error) {}
        })
    }

}