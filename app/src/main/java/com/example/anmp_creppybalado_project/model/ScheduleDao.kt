package com.example.anmp_creppybalado_project.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScheduleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg schedule: Schedule)

    @Query("SELECT * FROM schedule")
    fun getAllSchedule(): LiveData<List<Schedule>>
}