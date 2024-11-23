package com.example.anmp_creppybalado_project.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.anmp_creppybalado_project.databinding.ScheduleListItemBinding
import com.example.anmp_creppybalado_project.model.Schedule

class ScheduleListAdapter(val scheduleList:ArrayList<Schedule>)
    : RecyclerView.Adapter<ScheduleListAdapter.ScheduleViewHolder>() {
    class ScheduleViewHolder(var binding: ScheduleListItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val binding = ScheduleListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        return ScheduleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        holder.binding.txtTanggal.text = scheduleList[position].tanggal
        holder.binding.txtBulan.text = scheduleList[position].bulan
        holder.binding.txtDeskripsi.text = scheduleList[position].deskripsi
        holder.binding.txtGame.text = scheduleList[position].game
        holder.binding.txtTeam.text = scheduleList[position].team

        holder.binding.btnNext.setOnClickListener {
            val action = ScheduleFragmentDirections.actionScheduleDetail()
            Navigation.findNavController(it).navigate(action)
        }

    }

    fun updateScheduleList(newScheduleList: ArrayList<Schedule>) {
        scheduleList.clear()
        scheduleList.addAll(newScheduleList)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return scheduleList.size
    }
}