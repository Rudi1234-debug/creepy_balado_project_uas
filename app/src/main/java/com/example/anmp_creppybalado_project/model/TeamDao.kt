package com.example.anmp_creppybalado_project.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg member: Member)

    @Query("SELECT * FROM member")
    fun getAllMember(): LiveData<List<Member>>


}