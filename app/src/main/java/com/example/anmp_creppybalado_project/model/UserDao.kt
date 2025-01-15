package com.example.anmp_creppybalado_project.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.anmp_creppybalado_project.model.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User): Long
    @Query("SELECT * FROM User WHERE username = :username AND password = :password LIMIT 1")
    suspend fun getUser(username: String, password: String): User?
    @Query("SELECT * FROM User")
    fun getAllUsers(): LiveData<List<User>>
}