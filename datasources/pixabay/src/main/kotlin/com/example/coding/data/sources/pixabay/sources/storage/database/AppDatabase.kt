package com.example.coding.data.sources.pixabay.sources.storage.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coding.data.sources.pixabay.sources.storage.database.converter.StringListConverter
import com.example.coding.data.sources.pixabay.sources.storage.database.dao.HitDao
import com.example.coding.data.sources.pixabay.sources.storage.model.HitEntity

@Database(
    entities = [HitEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(StringListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract val hitDao: HitDao

    companion object {
        const val DATABASE_NAME = "database.db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }


        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java,
                DATABASE_NAME
            )
                .enableMultiInstanceInvalidation()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}