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
import com.example.anmp_creppybalado_project.model.Schedule
import com.example.anmp_creppybalado_project.view.ScheduleFragmentDirections
import com.example.anmp_creppybalado_project.view.ScheduleListAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class   ListScheduleModel(application: Application) : AndroidViewModel(application) {

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    val scheduleLD = MutableLiveData<ArrayList<Schedule>>()
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
    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}
