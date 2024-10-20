package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentScheduleBinding
import com.example.anmp_creppybalado_project.viewmodel.ListScheduleModel

class ScheduleFragment : Fragment() {
        private lateinit var viewModel: ListScheduleModel
        private val scheduleListAdapter  = ScheduleListAdapter(arrayListOf())
        private lateinit var binding: FragmentScheduleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListScheduleModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = scheduleListAdapter
        binding.refreshLayout.setOnRefreshListener {
            binding.recView.visibility = View.GONE
            binding.txtError.visibility = View.GONE
            binding.progressLoad.visibility = View.VISIBLE
            viewModel.refresh()
            binding.refreshLayout.isRefreshing = false
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.scheduleLD.observe(viewLifecycleOwner, Observer {
            scheduleListAdapter.updateScheduleList(it)
        })
        viewModel.scheduleLoadErrorLD.observe(viewLifecycleOwner, Observer {
            if(it == true) {
                binding.txtError?.visibility = View.VISIBLE
                binding.progressLoad.visibility = View.VISIBLE
            } else {
                binding.txtError?.visibility = View.GONE
                binding.progressLoad.visibility = View.GONE
            }
        })

    }
}