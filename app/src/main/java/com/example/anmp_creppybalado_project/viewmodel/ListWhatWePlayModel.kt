package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.anmp_creppybalado_project.model.ModelDatabase
import com.example.anmp_creppybalado_project.model.WhatWePlay
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListWhatWePlayModel(application: Application) : AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    //val whatWePlayLD = MutableLiveData<ArrayList<WhatWePlay>>()
    val _whatWePlayLD = MutableLiveData<List<WhatWePlay>?>() // Change to MutableLiveData
    val whatWePlayLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    // Inisialisasi database
    private val db = ModelDatabase.buildDatabase(getApplication())
    private val whatWePlayDao = db.whatWePlayDao()
    /*fun refresh(){
        whatWePlayLoadErrorLD.value = true
        loadingLD.value = true
        queue = Volley.newRequestQueue( getApplication() )
        val url = "https://www.jsonkeeper.com/b/QAIP"
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            {
                val sType = object : TypeToken<List<WhatWePlay>>() { }.type
                val result = Gson().fromJson<List<WhatWePlay>>(it, sType)
                _whatWePlayLD.value = result as ArrayList<WhatWePlay>?
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
    }*/
    fun refresh() {
        // Set loading and error states
        whatWePlayLoadErrorLD.value = true
        loadingLD.value = true

        // Use a background thread to fetch data from the database
        Thread {
            // Fetch data from the DAO
            val data = whatWePlayDao.getAllWhatWePlay().value // This will be LiveData, so it may be null initially

            // Check if data is not null
            if (data != null) {
                _whatWePlayLD.postValue(data) // Use postValue to update LiveData from the background thread
            } else {
                // Handle the case where data is null (e.g., no data in the database)
                _whatWePlayLD.postValue(emptyList()) // Or handle it as you see fit
            }

            // Set loading state to false
            loadingLD.postValue(false) // Again, use postValue here
        }.start()
    }





    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    fun insertSampleData() {
        val json = """
        [
            {"id":"1","url":"https://www.acerid.com/wp-content/uploads/2021/05/thumbnail-1.jpg","name":"VALORANT","description":"Valorant is a free-to-play first-person tactical hero shooter developed and published by Riot Games. The game's development started in 2014 and was teased under the codename Project A in October 2019. A closed beta period began with limited access on April 7, 2020, followed by a release on June 2, 2020."},
            {"id":"2","url":"https://www.lead.co.id/wp-content/uploads/2023/07/IMG_20230702_191320.jpg","name":"MOBILE LEGENDS","description":"Mobile Legends: Bang Bang (MLBB) is a mobile multiplayer online battle arena (MOBA) game developed and published by Chinese developer Moonton, a subsidiary of ByteDance. The game was released in 2016 and grew in popularity, most prominently in Southeast Asia."},
            {"id":"3","url":"https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/730/capsule_616x353.jpg?t=1719426374","name":"COUNTER STRIKE 2","description":"Counter-Strike 2 is a 2023 free-to-play tactical first-person shooter game developed and published by Valve. It is the fifth entry in the Counter-Strike series, developed as an updated version of the previous entry, Counter-Strike: Global Offensive (2012). The game was announced on March 22, 2023, and was released on September 27, 2023, for Windows and Linux, replacing Global Offensive on Steam."},
            {"id":"4","url":"https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/570/capsule_616x353.jpg?t=1724428927","name":"DOTA 2","description":"Dota 2 is a 2013 multiplayer online battle arena (MOBA) video game by Valve. The game is a sequel to Defense of the Ancients (DotA), a community-created mod for Blizzard Entertainment's Warcraft III: Reign of Chaos."},
            {"id":"5","url":"https:// gambar.sgp1.digitaloceanspaces.com/wp-content/uploads/2020/07/1-68.jpg","name":"PUBG MOBILE","description":"PUBG Mobile is a free-to-play battle royale video game co-developed by LightSpeed & Quantum Studio and PUBG Studios. It is a mobile game adaptation of PUBG: Battlegrounds. It was initially released for Android and iOS on 19th of March 2018."}
        ]
        """
        val gson = Gson()
        val whatWePlayList = gson.fromJson(json, Array<WhatWePlay>::class.java)

        // Use a background thread to insert data into the database
        Thread {
            whatWePlayDao.insertAll(*whatWePlayList) // Insert data into the database
            refresh() // Refresh the LiveData to reflect the new data
        }.start()
    }

}