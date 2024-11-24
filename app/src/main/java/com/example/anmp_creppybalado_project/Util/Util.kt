package com.example.anmp_creppybalado_project.Util


import android.content.Context
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.anmp_creppybalado_project.model.ModelDatabase

val DB_NAME = "newtododb"


fun buildDb(context: Context): ModelDatabase{
    val db = ModelDatabase.buildDatabase(context)
    return db
}

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE user ADD COLUMN priority INTEGER DEFAULT 3 not null")
    }
}

