package com.example.anmp_creppybalado_project.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.anmp_creppybalado_project.databinding.HomeCardItemBinding
import com.example.anmp_creppybalado_project.model.WhatWePlay
import com.squareup.picasso.Picasso

class WhatWePlayAdapter(val whatWePlayList:ArrayList<WhatWePlay>, val)
    :RecyclerView.Adapter<WhatWePlayAdapter.WhatWePlayViewHolder>()
{
    class WhatWePlayViewHolder(var binding: HomeCardItemBinding)
        :RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):WhatWePlayViewHolder {
        val binding = HomeCardItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return WhatWePlayViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return whatWePlayList.size
    }

    fun updateWhatWePlayList(newWhatWePlayList: ArrayList<WhatWePlay>) {
        whatWePlayList.clear()
        whatWePlayList.addAll(newWhatWePlayList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: WhatWePlayViewHolder, position: Int) {
        Picasso.get()
            .load(whatWePlayList[position].url)
            .into(holder.binding.imgGame)
        holder.binding.txtGame.text = whatWePlayList[position].name
        holder.binding.txtDescription.text = whatWePlayList[position].description

        holder.binding.btnAchievement.setOnClickListener {

        }

        holder.binding.btnTeam.setOnClickListener {
            val action = WhatWePlayFragmentDirections.actionTeamFragment(
                whatWePlayList[position].url ?: ""
            )
            Navigation.findNavController(it).navigate(action)
        }
    }
}