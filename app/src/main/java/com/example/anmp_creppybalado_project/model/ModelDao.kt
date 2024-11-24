package com.example.anmp_creppybalado_project.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user: User)

    @Query("SELECT * FROM user") // kalo perlu ORDER BY, tambah ORDER BY
    fun selectAllTodo(): List<User>

    @Query("SELECT * FROM user WHERE userid= :id")
    fun selectTodo(id:Int): User

    @Query("UPDATE User SET firstname=:firstname, lastname=:lastname, username=:username WHERE userid = :id")
    fun update(firstname:String, lastname:String, username:String, id:Int)

    @Delete
    fun deleteTodo(todo:User)

}