package com.example.anmp_creppybalado_project.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBindings
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentHomeBinding
import com.example.anmp_creppybalado_project.databinding.FragmentWhatWePlayBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.btnWhatWePlay.setOnClickListener {
            findNavController().navigate(R.id.whatWePlayFragment)
        }
        binding.bottomNav.setOnNavigationItemReselectedListener { menu ->
            when (menu.itemId){
                R.id.actionWhatWePlay ->{
                    findNavController().navigate(R.id.whatWePlayFragment)
                    true
                }
                R.id.actionScheduleFragment->{
                    findNavController().navigate(R.id.scheduleFragment)
                    true
                }
                R.id.actionWhoWeAre->{
                    findNavController().navigate(R.id.whoWeAreFragment)
                    true
                }
                else->false
            }
        }

        binding.navView.setNavigationItemSelectedListener { menu->
            when (menu.itemId){
                R.id.actionWhatWePlay ->{
                    findNavController().navigate(R.id.whatWePlayFragment)
                    true
                }
                R.id.actionScheduleFragment->{
                    findNavController().navigate(R.id.scheduleFragment)
                    true
                }
                R.id.actionWhoWeAre->{
                    findNavController().navigate(R.id.whoWeAreFragment)
                    true
                }
                else->false
            }
        }

        return binding.root
    }

}