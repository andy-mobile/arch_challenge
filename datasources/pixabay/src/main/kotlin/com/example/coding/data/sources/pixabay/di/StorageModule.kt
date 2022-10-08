package com.example.coding.data.sources.pixabay.di

import android.content.Context
import com.example.coding.data.sources.pixabay.sources.storage.database.AppDatabase
import com.example.coding.data.sources.pixabay.sources.storage.database.dao.HitDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Provides
    @Singleton
    fun provideDatabaseManager(context: Context) = AppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provide(appDatabase: AppDatabase): HitDao {
       return appDatabase.hitDao
    }
}