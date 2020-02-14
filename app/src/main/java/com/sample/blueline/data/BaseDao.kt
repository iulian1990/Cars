package com.sample.musicx.data

import androidx.room.*

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(t: T): Long

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(ts: List<T>): List<Long>

    @Delete
    fun delete(t: T)

    @Update
    fun update(t: T)
}