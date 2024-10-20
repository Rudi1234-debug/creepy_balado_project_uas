package com.example.anmp_creppybalado_project.model

import android.widget.DatePicker
import com.google.gson.annotations.SerializedName

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
    val datePicker: DatePicker?,
    val eventName: String?,
    val teamName: String?,
    val description: String?,
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

