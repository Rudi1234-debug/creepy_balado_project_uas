package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.anmp_creppybalado_project.model.WhatWePlay
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListWhatWePlayModel(application: Application) : AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    val whatWePlayLD = MutableLiveData<ArrayList<WhatWePlay>>()
    val whatWePlayLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()
    fun refresh(){
        whatWePlayLoadErrorLD.value = true
        loadingLD.value = true
        queue = Volley.newRequestQueue( getApplication() )
        val url = "https://www.jsonkeeper.com/b/QAIP"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<WhatWePlay>>() { }.type
                val result = Gson().fromJson<List<WhatWePlay>>(it, sType)
                whatWePlayLD.value = result as ArrayList<WhatWePlay>?
                loadingLD.value = false
                Log.d("showvoley", result.toString())
            },
            {
                Log.d("showvoley", it.toString())
                whatWePlayLoadErrorLD.value = false
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