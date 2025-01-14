package com.example.anmp_creppybalado_project.view

import android.app.Activity
import android.content.Context
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
import com.example.anmp_creppybalado_project.model.ModelDatabase
import com.example.anmp_creppybalado_project.viewmodel.ListWhatWePlayModel

class WhatWePlayFragment : Fragment() {

    private lateinit var viewModel: ListWhatWePlayModel
    private val whatWePlayAdapter = WhatWePlayAdapter(arrayListOf())
    private lateinit var binding: FragmentWhatWePlayBinding
    private lateinit var bindings: HomeCardItemBinding //binding untuk tombol masing-masing card

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWhatWePlayBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListWhatWePlayModel::class.java)
        viewModel.refresh()
        viewModel.insertSampleData()

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

    /*fun observeViewModel() {
        /*viewModel.whatWePlayLD.observe(viewLifecycleOwner, Observer {
           whatWePlayAdapter.updateWhatWePlayList(it)
            binding.recView.visibility = View.VISIBLE
            binding.progressLoad.visibility = View.GONE
        })*/
        viewModel._whatWePlayLD.observe(viewLifecycleOwner, Observer { whatWePlayList ->
            whatWePlayAdapter.updateWhatWePlayList(ArrayList(whatWePlayList))
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
    }*/

    private fun observeViewModel() {
        viewModel._whatWePlayLD.observe(viewLifecycleOwner, Observer { whatWePlayList ->
            // Check if whatWePlayList is not null before updating the adapter
            whatWePlayList?.let {
                whatWePlayAdapter.updateWhatWePlayList(ArrayList(it))
                binding.recView.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.GONE
            } ?: run {
                // Handle the case where the list is null
                binding.recView.visibility = View.GONE
                binding.progressLoad.visibility = View.VISIBLE
            }
        })

        viewModel.whatWePlayLoadErrorLD.observe(viewLifecycleOwner, Observer { isLoading ->
            binding.progressLoad.visibility = if (isLoading == true) View.VISIBLE else View.GONE
        })
    }
}
