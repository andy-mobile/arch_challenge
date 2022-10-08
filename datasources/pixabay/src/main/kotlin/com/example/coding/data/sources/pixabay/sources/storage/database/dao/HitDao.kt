package com.example.coding.data.sources.pixabay.sources.storage.database.dao

import androidx.paging.PagingSource
import androidx.room.*
import com.example.coding.data.sources.pixabay.sources.storage.model.HitEntity

@Dao
interface HitDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(values: List<HitEntity>)

    @Query("SELECT * FROM hit")
    fun getPaged(): PagingSource<Int, HitEntity>

    @Query("SELECT * FROM hit WHERE item_id = :id")
    suspend fun getByItemId(id: Int): HitEntity?

    @Query("DELETE FROM hit")
    suspend fun delete()

    @Transaction
    suspend fun refresh(values: List<HitEntity>){
        delete()
        insert(values)
    }
}