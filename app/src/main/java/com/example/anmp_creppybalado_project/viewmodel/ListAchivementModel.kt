package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.anmp_creppybalado_project.model.GameAchievement
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import android.util.Log
import com.example.anmp_creppybalado_project.model.Achievements
import com.example.anmp_creppybalado_project.model.achieveDoang

class ListAchivementModel(application: Application):AndroidViewModel(application){
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    val achievementLD = MutableLiveData<ArrayList<GameAchievement>>()
//    val achievementsYearLD = MutableLiveData<ArrayList<Achievements>>()
    val achievementLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val achivementDoangLD=MutableLiveData<GameAchievement>()

    /*fun fetch()
    {
        achivementDoangLD.value =
            GameAchievement("Rank 4 Junior Open Elite Class 2024")
        achievementLoadErrorLD.value = true
        loadingLD.value = true
    }*/
    fun refresh(){
        achievementLoadErrorLD.value = true
        loadingLD.value=true
        queue=Volley.newRequestQueue(getApplication())
        val url="https://www.jsonkeeper.com/b/O7Y7"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object :TypeToken<List<GameAchievement>>() {}.type
                val result = Gson().fromJson<List<GameAchievement>>(it, sType)
                achievementLD.value = result as ArrayList<GameAchievement>?
                loadingLD.value=false
                Log.d("showvolley", result.toString())
            },
            {
                Log.d("showvolley", it.toString())
                achievementLoadErrorLD.value=false
                loadingLD.value=false
            }
        )
        stringRequest.tag=TAG
        queue?.add(stringRequest)
    }

//    fun getAchievements(gameName: String) {
//        refresh()
//        achievementLD.observeForever { allAchievements ->
//            if (allAchievements != null) {
//                val filteredAchievements = allAchievements.filter { it.name == gameName }
//                achievementLD.value = ArrayList(filteredAchievements)
//            }
//        }
//    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}