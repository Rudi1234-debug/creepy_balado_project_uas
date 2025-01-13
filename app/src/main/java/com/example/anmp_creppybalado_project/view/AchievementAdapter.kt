package com.example.anmp_creppybalado_project.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.anmp_creppybalado_project.R
import com.example.anmp_creppybalado_project.databinding.FragmentAchievementBinding
import com.example.anmp_creppybalado_project.databinding.HomeCardItemBinding
import com.example.anmp_creppybalado_project.model.GameAchievement
import com.example.anmp_creppybalado_project.model.WhatWePlay
import com.squareup.picasso.Picasso

class AchievementAdapter(val achList:ArrayList<GameAchievement>)
    :RecyclerView.Adapter<AchievementAdapter.AchievementViewHolder>()
{
    class AchievementViewHolder(var binding: FragmentAchievementBinding)
        :RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):AchievementViewHolder {
        val binding = FragmentAchievementBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AchievementViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return achList.size
    }

    fun updateAchList(newAchList: ArrayList<GameAchievement>) {
        achList.clear()
        achList.addAll(newAchList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AchievementViewHolder, position: Int) {
//        Picasso.get()
//            .load(achList[position].image)
//            .into(holder.binding.imgAch)
//        holder.binding.lblGameName.text = achList[position].name

    }
}