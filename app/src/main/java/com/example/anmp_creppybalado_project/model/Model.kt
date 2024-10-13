package com.example.anmp_creppybalado_project.model

import android.widget.DatePicker

data class WhatWePlay(
    val name: String?,
    val description: String?,
    val detail: DetailPlay?,
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

