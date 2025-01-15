package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentRegisterBinding
import com.example.anmp_creppybalado_project.viewmodel.RegisterViewModel

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
        viewModel.registerSuccessLD.observe(viewLifecycleOwner, { success ->
            if (success) {
                findNavController().navigate(R.id.action_register_to_login)
            } else {

            }
        })

        binding.btnEnter.setOnClickListener {
            // Validasi input
            val username = binding.txtNewUsername.text.toString()
            val password = binding.txtNewPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                viewModel.onRegisterClicked()
            } else {
                // Tampilkan pesan jika ada input yang kosong
                Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

}