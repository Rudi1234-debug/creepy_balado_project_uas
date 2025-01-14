    package com.example.anmp_creppybalado_project.model

    import androidx.lifecycle.LiveData
    import androidx.room.Dao
    import androidx.room.Delete
    import androidx.room.Insert
    import androidx.room.OnConflictStrategy
    import androidx.room.Query

    @Dao
    interface WhatWePlayDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insertAll(vararg whatWePlay: WhatWePlay)

        @Query("SELECT * FROM WhatWePlay")
        fun getAllWhatWePlay(): LiveData<List<WhatWePlay>>

        @Delete
        fun deleteWhatWePlay(whatWePlay: WhatWePlay)
    }