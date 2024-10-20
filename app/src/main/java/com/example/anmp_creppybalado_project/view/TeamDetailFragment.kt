package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentTeamBinding
import com.example.anmp_creppybalado_project.databinding.FragmentTeamDetailBinding
import com.example.anmp_creppybalado_project.viewmodel.ListTeamModel
import com.squareup.picasso.Picasso


class TeamDetailFragment : Fragment() {
    private lateinit var binding: FragmentTeamDetailBinding
    private lateinit var viewModel: ListTeamModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageUrl = arguments?.let { TeamDetailFragmentArgs.fromBundle(it).url }

        imageUrl?.let { url ->
            Picasso.get().load(url).into(binding.imgGameTeam)
        }
    }
}