package com.example.anmp_creppybalado_project.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.anmp_creppybalado_project.Util.DB_NAME
import com.example.anmp_creppybalado_project.Util.MIGRATION_1_2

@Database(entities = arrayOf(User::class), version =  2)
abstract class ModelDatabase: RoomDatabase() {
    abstract fun modelDao(): ModelDao

    companion object {
        @Volatile
        private var instance: ModelDatabase? = null
        private val LOCK = Any()

        fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ModelDatabase::class.java, DB_NAME
        )
            .addMigrations(MIGRATION_1_2)
            .build()

//        fun buildDatabase(context: Context) =
//            Room.databaseBuilder(
//                context.applicationContext,
//                TodoDatabase::class.java,
//                DB_NAME
//            ).build()

        operator fun invoke(context: Context) {
            if (instance == null) {
                synchronized(LOCK) {
                    instance ?: buildDatabase(context).also {
                        instance = it
                    }
                }
            }
        }
    }
}
