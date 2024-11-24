package com.example.anmp_creppybalado_project.model

import android.widget.DatePicker
import com.google.gson.annotations.SerializedName
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

data class WhatWePlay(
    val id: String?,
    val url: String?,
    val name: String?,
    val description: String?,
)

data class DetailPlay(
    val year: DatePicker?,
    val records: String?
)

data class Schedule(
    val id: String?,
    val tanggal: String?,
    val bulan: String?,
    val deskripsi: String?,
    val game: String?,
    val team: String?
    )
data class Member(
    val team: String,
    val game: String,
    val name: String,
    val profil: String,
    val role: String
)

data class Game(
    val id: String?,
    val name: String,
    val url: String?
)

data class GameAchievement(
//    val name: String,
//    val image: String,
//    val achievements: List<Achievements>,
//    val achievementYears: List<Int>
    val achdesc:String
)

data class Achievements(
    val title: String,
    val description: String,
    val year: Int
)

data class achieveDoang(
    val gameDesc:String,
)

data class RudiList(
    val name: String?
)

@Entity
data class User(
    @ColumnInfo(name="firstname")
    var firstname: String?,
    @ColumnInfo(name="lastname")
    var lastname: String?,
    @ColumnInfo(name="username")
    var username: String?,
    @ColumnInfo(name="password")
    var password: String?,
){
    @PrimaryKey(autoGenerate = true)
    var userid:Int = 0

}


