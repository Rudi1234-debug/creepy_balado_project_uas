package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentWhatWePlayBinding
import com.example.anmp_creppybalado_project.databinding.HomeCardItemBinding
import com.example.anmp_creppybalado_project.viewmodel.ListWhatWePlayModel

class WhatWePlayFragment : Fragment() {
    private lateinit var viewModel: ListWhatWePlayModel
    private val whatWePlayAdapter  = WhatWePlayAdapter(arrayListOf(), arrayListOf())
    private lateinit var binding: FragmentWhatWePlayBinding
    private lateinit var bindings: HomeCardItemBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWhatWePlayBinding.inflate(inflater, container, false)
        bindings = HomeCardItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListWhatWePlayModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = whatWePlayAdapter
        binding.refreshLayout.setOnRefreshListener {
            binding.recView.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }

        observeViewModel()

    }

    fun observeViewModel() {
        viewModel.whatWePlayLD.observe(viewLifecycleOwner, Observer {
           whatWePlayAdapter.updateWhatWePlayList(it)
            binding.recView.visibility = View.VISIBLE
            binding.progressLoad.visibility = View.GONE
        })
        viewModel.whatWePlayLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.progressLoad.visibility = View.GONE
            }
        })

    }
}