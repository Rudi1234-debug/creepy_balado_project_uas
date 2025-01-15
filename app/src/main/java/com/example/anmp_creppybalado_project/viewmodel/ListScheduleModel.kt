package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.Navigation
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.anmp_creppybalado_project.model.ModelDatabase
import com.example.anmp_creppybalado_project.model.Schedule
import com.example.anmp_creppybalado_project.model.WhatWePlay
import com.example.anmp_creppybalado_project.view.ScheduleFragmentDirections
import com.example.anmp_creppybalado_project.view.ScheduleListAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class   ListScheduleModel(application: Application) : AndroidViewModel(application) {

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    //val scheduleLD = MutableLiveData<ArrayList<Schedule>>()
    val scheduleLD = MutableLiveData<List<Schedule>?>()
    val scheduleLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val scheduleDoangLD = MutableLiveData<Schedule>()

    fun fetch(){
        var a= Schedule("9", "7","9","yyyy","dfrfr","tfgtt")
       scheduleDoangLD.value = a
    }
    fun refresh() {
        scheduleLoadErrorLD.value = false
        loadingLD.value = true
        queue = Volley.newRequestQueue( getApplication() )
        val url = "https://www.jsonkeeper.com/b/6E4B"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<Schedule>>() { }.type
                val result = Gson().fromJson<List<Schedule>>(it, sType)
                scheduleLD.value = result as ArrayList<Schedule>?
                loadingLD.value = false
                scheduleLoadErrorLD.value = false
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                scheduleLoadErrorLD.value = false
                loadingLD.value = false
            }
        )
        stringRequest.tag = TAG
        queue?.add(stringRequest)

    }
    /*fun refresh() {
        val schedules = arrayListOf(
            com.example.anmp_creppybalado_project.model.Schedule(
                id = "0",
                tanggal = "05",
                bulan = "Sep",
                deskripsi = "Regional Qualifier - Valorant",
                game = "VALORANT",
                team = "Team A"
            ),
            com.example.anmp_creppybalado_project.model.Schedule(
                id = "1",
                tanggal = "02",
                bulan = "Okt",
                deskripsi = "Regional Qualifier - Mobile Legend",
                game = "MOBILE LEGENDS",
                team = "Team B"
            ),
            com.example.anmp_creppybalado_project.model.Schedule(
                id = "2",
                tanggal = "15",
                bulan = "Sep",
                deskripsi = "Regional Qualifier - Counter Strike 2",
                game = "COUNTER STRIKE 2",
                team = "Team C"
            ),
            com.example.anmp_creppybalado_project.model.Schedule(
                id = "3",
                tanggal = "08",
                bulan = "Nov",
                deskripsi = "Regional Qualifier - Dota 2",
                game = "DOTA 2",
                team = "Team D"
            ),
            com.example.anmp_creppybalado_project.model.Schedule(
                id = "4",
                tanggal = "10",
                bulan = "Sep",
                deskripsi = "Regional Qualifier - PUBG Mobile",
                game = "PUBG MOBILE",
                team = "Team E"
            )
        )

        // Gunakan thread untuk memasukkan data ke database
        Thread {
            val scheduleDao = ModelDatabase.buildDatabase(getApplication()).scheduleDao()
            scheduleDao.insertAll(*schedules.toTypedArray())
            Log.d("refresh", "Data Schedule berhasil disimpan di database.")
        }.start()
    }*/

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    /*fun insertSchedule() {
        val scheduleDao = ModelDatabase.buildDatabase(getApplication()).scheduleDao()
        val liveDataSchedule = scheduleDao.getAllSchedule()
        liveDataSchedule.observeForever { schedules ->
            scheduleLD.postValue(schedules)
            Log.d("insertSampleData", "Sample data berhasil dimasukkan ke scheduleLD.")
        }
    }*/


}
