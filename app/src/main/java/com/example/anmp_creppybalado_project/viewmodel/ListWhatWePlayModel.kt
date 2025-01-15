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
    val _whatWePlayLD = MutableLiveData<List<WhatWePlay>?>()
    val whatWePlayLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

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
        val whatweplay = arrayListOf(
            com.example.anmp_creppybalado_project.model.WhatWePlay(
                id = "1",
                name = "VALORANT",
                url = "https://www.acerid.com/wp-content/uploads/2021/05/thumbnail-1.jpg",
                description = "Valorant is a free-to-play first-person tactical hero shooter developed and published by Riot Games. The game's development started in 2014 and was teased under the codename Project A in October 2019. A closed beta period began with limited access on April 7, 2020, followed by a release on June 2, 2020."
            ),
            com.example.anmp_creppybalado_project.model.WhatWePlay(
                id = "2",
                name = "MOBILE LEGENDS",
                url = "https://www.lead.co.id/wp-content/uploads/2023/07/IMG_20230702_191320.jpg",
                description = "Mobile Legends: Bang Bang (MLBB) is a mobile multiplayer online battle arena (MOBA) game developed and published by Chinese developer Moonton, a subsidiary of ByteDance. The game was released in 2016 and grew in popularity, most prominently in Southeast Asia."
            ),
            com.example.anmp_creppybalado_project.model.WhatWePlay(
                id = "3",
                name = "COUNTER STRIKE 2",
                url = "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/730/capsule_616x353.jpg?t=1719426374",
                description = "Counter-Strike 2 is a 2023 free-to-play tactical first-person shooter game developed and published by Valve. It is the fifth entry in the Counter-Strike series, developed as an updated version of the previous entry, Counter-Strike: Global Offensive (2012). The game was announced on March 22, 2023, and was released on September 27, 2023, for Windows and Linux, replacing Global Offensive on Steam."
            ),
            com.example.anmp_creppybalado_project.model.WhatWePlay(
                id = "4",
                name = "DOTA 2",
                url = "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/570/capsule_616x353.jpg?t=1724428927",
                description = "Dota 2 is a 2013 multiplayer online battle arena (MOBA) video game by Valve. The game is a sequel to Defense of the Ancients (DotA), a community-created mod for Blizzard Entertainment's Warcraft III: Reign of Chaos."
            ),
            com.example.anmp_creppybalado_project.model.WhatWePlay(
                id = "5",
                name = "PUBG MOBILE",
                url = "https://gambar.sgp1.digitaloceanspaces.com/wp-content/uploads/2020/07/1-68.jpg",
                description = "PUBG Mobile is a free-to-play battle royale video game co-developed by LightSpeed & Quantum Studio and PUBG Studios. It is a mobile game adaptation of PUBG: Battlegrounds. It was initially released for Android and iOS on 19th of March 2018."
            )
        )

        Thread {
            val whatweplayDao = ModelDatabase.buildDatabase(getApplication()).whatWePlayDao()
            whatweplayDao.insertAll(*whatweplay.toTypedArray())
            Log.d("refresh", "Data berhasil disimpan di database.")
        }.start()
    }


    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }

    fun insertWhatWePlay() {
        val whatweplayDao = ModelDatabase.buildDatabase(getApplication()).whatWePlayDao()
        val liveDataGames = whatweplayDao.getAllWhatWePlay()
        liveDataGames.observeForever { games ->
            _whatWePlayLD.postValue(games)
            Log.d("insertSampleData", "Sample data berhasil dimasukkan ke _whatWePlayLD.")
        }
    }
}
