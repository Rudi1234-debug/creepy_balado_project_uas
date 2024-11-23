package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentWhatWePlayBinding
import com.example.anmp_creppybalado_project.databinding.FragmentWhoWeAreBinding
import com.example.anmp_creppybalado_project.databinding.HomeCardItemBinding


class WhoWeAreFragment : Fragment() {
    private lateinit var binding: FragmentWhoWeAreBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWhoWeAreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var likeAmount = 0
        binding.btnLike.setOnClickListener {
            likeAmount++
            binding.btnLike.text = likeAmount.toString() + " likes"
        }

    }

}