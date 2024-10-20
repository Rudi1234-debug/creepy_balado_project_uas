package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.anmp_creppybalado_project.model.Game

class ListTeamModel(application: Application):AndroidViewModel(application) {
    val gamesLD = MutableLiveData<ArrayList<Game>>()

    fun refresh(){
        gamesLD.value = arrayListOf(
            Game(id = "1", name = "VALORANT",url = "https://www.acerid.com/wp-content/uploads/2021/05/thumbnail-1.jpg"),
            Game(id = "2", name = "MOBILE LEGENDS" ,url = "https://www.lead.co.id/wp-content/uploads/2023/07/IMG_20230702_191320.jpg"),
            Game(id = "3", name = "COUNTER STRIKE 2", url = "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/730/capsule_616x353.jpg?t=1719426374"),
            Game(id = "4", name = "DOTA 2" ,url = "https://shared.akamai.steamstatic.com/store_item_assets/steam/apps/570/capsule_616x353.jpg?t=1724428927"),
            Game(id = "5", name = "PUBG MOBILE" ,url = "https://gambar.sgp1.digitaloceanspaces.com/wp-content/uploads/2020/07/1-68.jpg")
        )
    }
}