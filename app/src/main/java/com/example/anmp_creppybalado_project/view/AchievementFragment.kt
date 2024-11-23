package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentAchievementBinding
import com.example.anmp_creppybalado_project.model.GameAchievement
import com.example.anmp_creppybalado_project.viewmodel.ListAchivementModel


class AchievementFragment : Fragment() {
    private lateinit var viewModel: ListAchivementModel
    private lateinit var binding: FragmentAchievementBinding
    private var imageUrl: String? = null
    private var gameName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_achievement, container, false)
//        viewModel = ViewModelProvider(this).get(AchievementViewModel::class.java)
        binding = FragmentAchievementBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        gameName = arguments?.getString("gameName")

        viewModel = ViewModelProvider(this).get(ListAchivementModel::class.java)

        gameName = arguments?.getString("gameName")

//        viewModel.refresh()

        viewModel.fetch()

//        binding.lblDescAch.text =
//
//        viewModel.achievementLD.observe(viewLifecycleOwner){achievementList ->
//            viewModel.getAchievements(gameName ?: "")
//            val yearAdapter = ArrayAdapter(
//                requireContext(),
//                androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item,
//                achievementList.map { it.achievementYears } // Mengambil tahun dari setiap achievement
//            )
//            binding.spnAchiveYear.adapter = yearAdapter
//
//            binding.spnAchiveYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//                override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
//
//                    val selectedYear = parent.getItemAtPosition(pos) as Int
//
//                    val selectedAchievement = achievementList.find { it.achievementYears.equals(selectedYear) }
//                    selectedAchievement?.let {
//                        binding.lblDescAch.text = "${it.achievements.get(1)} ${it.achievements.get(2)}"
//                    } ?: run {
//                        binding.lblDescAch.text = "Belum ada riwayat"
//                    }
//
//                }

//                override fun onNothingSelected(parent: AdapterView<*>) {
//                    // Do nothing
//                }


    }
    fun observeViewModel(){
        viewModel.achivementDoangLD.observe(viewLifecycleOwner, Observer {
            binding.lblDescAch.text = it.achdesc
        })
    }

}