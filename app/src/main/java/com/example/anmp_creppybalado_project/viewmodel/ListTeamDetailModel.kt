package com.example.anmp_creppybalado_project.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.anmp_creppybalado_project.model.Member

class ListTeamDetailModel(application: Application) : AndroidViewModel(application) {

    val membersLD = MutableLiveData<ArrayList<Member>>()
    val membersLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    fun refresh() {
        membersLD.value = arrayListOf(
            Member("A", "VALORANT", "Bambang Valo A", "https://i.pravatar.cc/100", "Duelist"),
            Member("A", "VALORANT", "Johan Valo A", "https://i.pravatar.cc/200", "Controller"),
            Member("A", "VALORANT", "Herman Valo A", "https://i.pravatar.cc/300", "Sentinel"),
            Member("B", "VALORANT", "Bambang Valo B", "https://i.pravatar.cc/400", "Duelist"),
            Member("B", "VALORANT", "Johan Valo B", "https://i.pravatar.cc/500", "Controller"),
            Member("B", "VALORANT", "Herman Valo B", "https://i.pravatar.cc/600", "Sentinel"),
            Member("C", "VALORANT", "Bambang Valo C", "https://i.pravatar.cc/700", "Duelist"),
            Member("C", "VALORANT", "Johan Valo C", "https://i.pravatar.cc/800", "Controller"),
            Member("C", "VALORANT", "Herman Valo C", "https://i.pravatar.cc/900", "Sentinel"),
            Member("A", "MOBILE LEGENDS", "Bambang ML A", "https://i.pravatar.cc/100", "Duelist"),
            Member("A", "MOBILE LEGENDS", "Johan ML A", "https://i.pravatar.cc/200", "Controller"),
            Member("A", "MOBILE LEGENDS", "Herman ML A", "https://i.pravatar.cc/300", "Sentinel"),
            Member("B", "MOBILE LEGENDS", "Bambang ML B", "https://i.pravatar.cc/400", "Duelist"),
            Member("B", "MOBILE LEGENDS", "Johan ML B", "https://i.pravatar.cc/500", "Controller"),
            Member("B", "MOBILE LEGENDS", "Herman ML B", "https://i.pravatar.cc/600", "Sentinel"),
            Member("C", "MOBILE LEGENDS", "Bambang ML C", "https://i.pravatar.cc/700", "Duelist"),
            Member("C", "MOBILE LEGENDS", "Johan ML C", "https://i.pravatar.cc/800", "Controller"),
            Member("C", "MOBILE LEGENDS", "Herman ML C", "https://i.pravatar.cc/900", "Sentinel"),
            Member("A", "COUNTER STRIKE 2", "Bambang CS A", "https://i.pravatar.cc/100", "Duelist"),
            Member("A", "COUNTER STRIKE 2", "Johan CS A", "https://i.pravatar.cc/200", "Controller"),
            Member("A", "COUNTER STRIKE 2", "Herman CS A", "https://i.pravatar.cc/300", "Sentinel"),
            Member("B", "COUNTER STRIKE 2", "Bambang CS B", "https://i.pravatar.cc/400", "Duelist"),
            Member("B", "COUNTER STRIKE 2", "Johan CS B", "https://i.pravatar.cc/500", "Controller"),
            Member("B", "COUNTER STRIKE 2", "Herman CS B", "https://i.pravatar.cc/600", "Sentinel"),
            Member("C", "COUNTER STRIKE 2", "Bambang CS C", "https://i.pravatar.cc/700", "Duelist"),
            Member("C", "COUNTER STRIKE 2", "Johan CS C", "https://i.pravatar.cc/800", "Controller"),
            Member("C", "COUNTER STRIKE 2", "Herman CS C", "https://i.pravatar.cc/900", "Sentinel"),
            Member("A", "DOTA 2", "Bambang Dota A", "https://i.pravatar.cc/100", "Duelist"),
            Member("A", "DOTA 2", "Johan Dota A", "https://i.pravatar.cc/200", "Controller"),
            Member("A", "DOTA 2", "Herman Dota A", "https://i.pravatar.cc/300", "Sentinel"),
            Member("B", "DOTA 2", "Bambang Dota B", "https://i.pravatar.cc/400", "Duelist"),
            Member("B", "DOTA 2", "Johan Dota B", "https://i.pravatar.cc/500", "Controller"),
            Member("B", "DOTA 2", "Herman Dota B", "https://i.pravatar.cc/600", "Sentinel"),
            Member("C", "DOTA 2", "Bambang Dota C", "https://i.pravatar.cc/700", "Duelist"),
            Member("C", "DOTA 2", "Johan Dota C", "https://i.pravatar.cc/800", "Controller"),
            Member("C", "DOTA 2", "Herman Dota C", "https://i.pravatar.cc/900", "Sentinel"),
            Member("A", "PUBG MOBILE", "Bambang PUBG M A", "https://i.pravatar.cc/100", "Duelist"),
            Member("A", "PUBG MOBILE", "Johan PUBG M A", "https://i.pravatar.cc/200", "Controller"),
            Member("A", "PUBG MOBILE", "Herman PUBG M A", "https://i.pravatar.cc/300", "Sentinel"),
            Member("B", "PUBG MOBILE", "Bambang PUBG M B", "https://i.pravatar.cc/400", "Duelist"),
            Member("B", "PUBG MOBILE", "Johan PUBG M B", "https://i.pravatar.cc/500", "Controller"),
            Member("B", "PUBG MOBILE", "Herman PUBG M B", "https://i.pravatar.cc/600", "Sentinel"),
            Member("C", "PUBG MOBILE", "Bambang PUBG M C", "https://i.pravatar.cc/700", "Duelist"),
            Member("C", "PUBG MOBILE", "Johan PUBG M C", "https://i.pravatar.cc/800", "Controller"),
            Member("C", "PUBG MOBILE", "Herman PUBG M C", "https://i.pravatar.cc/900", "Sentinel"),
        )
        membersLoadErrorLD.value = true
        loadingLD.value = true
    }
}