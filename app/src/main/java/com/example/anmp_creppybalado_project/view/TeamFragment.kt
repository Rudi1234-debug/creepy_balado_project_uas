package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentTeamBinding
import com.example.anmp_creppybalado_project.viewmodel.ListTeamDetailModel
import com.example.anmp_creppybalado_project.viewmodel.ListTeamModel
import com.squareup.picasso.Picasso

class TeamFragment : Fragment() {
    private lateinit var binding: FragmentTeamBinding
    private lateinit var viewModel: ListTeamDetailModel
    private var imageUrl: String? = null
    private var gameName: String? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUrl = arguments?.let { TeamFragmentArgs.fromBundle(it).url }
        imageUrl?.let { url ->
            Picasso.get().load(url).into(binding.imgGameTeam)
        }
        viewModel = ViewModelProvider(this).get(ListTeamDetailModel::class.java)
        viewModel.refresh()
        binding.btnTeamA.setOnClickListener {
            navigateToDetail(imageUrl)
        }

        binding.btnTeamB.setOnClickListener {
            navigateToDetail(imageUrl)
        }

        binding.btnTeamC.setOnClickListener {
            navigateToDetail(imageUrl)
        }

    }

    private fun navigateToDetail(url: String?) {
        url?.let {
            val action = TeamFragmentDirections.actionTeamDetailFragment(url = it)
            findNavController().navigate(action)
        }
    }
}