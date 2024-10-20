package com.example.anmp_creppybalado_project.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.anmp_creppybalado_project.databinding.TeamDetailItemBinding
import com.example.anmp_creppybalado_project.model.Member

class TeamDetailAdapter (val teamList:ArrayList<Member>)
    :RecyclerView.Adapter<TeamDetailAdapter.TeamDetailViewHolder>()
{
    class TeamDetailViewHolder(var binding: TeamDetailItemBinding)
        :RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):TeamDetailViewHolder {
        val binding = TeamDetailItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return TeamDetailViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return teamList.size
    }

    override fun onBindViewHolder(holder: TeamDetailViewHolder, position: Int) {
        holder.binding.txtName.text = teamList[position].name
        holder.binding.txtRole.text = teamList[position].role
    }
    fun updateStudentList(newStudentList: ArrayList<Member>) {
        teamList.clear()
        teamList.addAll(newStudentList)
        notifyDataSetChanged()
    }
}