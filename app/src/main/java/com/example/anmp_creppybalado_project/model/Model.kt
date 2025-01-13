package com.example.anmp_creppybalado_project.model

import android.widget.DatePicker
import com.google.gson.annotations.SerializedName
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*data class WhatWePlay(
    val id: String?,
    val url: String?,
    val name: String?,
    val description: String?,
)*/

data class DetailPlay(
    val year: DatePicker?,
    val records: String?
)

/*data class Schedule(
    val id: String?,
    val tanggal: String?,
    val bulan: String?,
    val deskripsi: String?,
    val game: String?,
    val team: String?
    )*/
/*data class Member(
    val team: String,
    val game: String,
    val name: String,
    val profil: String,
    val role: String
)*/

/*data class Game(
    val id: String?,
    val name: String,
    val url: String?
)*/

data class GameAchievement(
//    val name: String,
//    val image: String,
//    val achievements: List<Achievements>,
//    val achievementYears: List<Int>
    val achdesc:String
)

data class User(
    @ColumnInfo(name="name")
    var name: String?,
    @ColumnInfo(name="image")
    var image: String?,
    @ColumnInfo(name="achievement")
    var achievement: List<Achievements>?,
    @ColumnInfo(name="achievementYears")
    var achievementYears: List<Int>?,
)
/*data class Achievements(
    val title: String,
    val description: String,
    val year: Int
)*/

data class Achievements(
    @ColumnInfo(name="title")
    var title: String?,
    @ColumnInfo(name="description")
    var description: String?,
    @ColumnInfo(name="year")
    var year: Int?
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

@Entity
data class WhatWePlay(
    @ColumnInfo(name="id")
    val id: String?,
    @ColumnInfo(name="url")
    val url: String?,
    @ColumnInfo(name="name")
    val name: String?,
    @ColumnInfo(name="description")
    val description: String?,
)

@Entity
data class Member(
    @ColumnInfo(name="team")
    val team: String,
    @ColumnInfo(name="game")
    val game: String,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="profil")
    val profil: String,
    @ColumnInfo(name="role")
    val role: String
)

@Entity
data class Game(
    @ColumnInfo(name="id")
    val id: String?,
    @ColumnInfo(name="name")
    val name: String,
    @ColumnInfo(name="url")
    val url: String,
)

@Entity
data class Schedule(
    @ColumnInfo(name="id")
    val id: String?,
    @ColumnInfo(name="tanggal")
    val tanggal: String?,
    @ColumnInfo(name="bulan")
    val bulan: String?,
    @ColumnInfo(name="deskripsi")
    val deskripsi: String?,
    @ColumnInfo(name="game")
    val game: String?,
    @ColumnInfo(name="team")
    val team: String?
)



