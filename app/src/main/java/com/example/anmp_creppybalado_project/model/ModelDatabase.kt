    package com.example.anmp_creppybalado_project.model

    import android.content.Context
    import androidx.room.Database
    import androidx.room.Room
    import androidx.room.RoomDatabase
    import com.example.anmp_creppybalado_project.model.UserDao
    import com.example.anmp_creppybalado_project.Util.DB_NAME
    import com.example.anmp_creppybalado_project.Util.MIGRATION_1_2

    @Database(entities = [User ::class, WhatWePlay::class], version = 2)
    abstract class ModelDatabase : RoomDatabase() {
        abstract fun modelDao(): ModelDao
        abstract fun whatWePlayDao(): WhatWePlayDao
        abstract fun userDao(): UserDao

        companion object {
            @Volatile
            private var instance: ModelDatabase? = null
            private val LOCK = Any()

            fun buildDatabase(context: Context): ModelDatabase {
                return instance ?: synchronized(LOCK) {
                    instance ?: Room.databaseBuilder(
                        context.applicationContext,
                        ModelDatabase::class.java,
                        DB_NAME
                    ).addMigrations(MIGRATION_1_2)
                        .build().also { instance = it }
                }
            }
        }
    }
