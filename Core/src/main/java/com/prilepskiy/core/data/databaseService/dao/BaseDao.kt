package com.prilepskiy.core.data.databaseService.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

@Dao
abstract class BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(data: List<T>)

    @Update
    abstract suspend fun update(data: T)

    @Delete
    abstract suspend fun delete(data: T)
}