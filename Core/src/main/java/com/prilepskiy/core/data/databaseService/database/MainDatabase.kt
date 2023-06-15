package com.prilepskiy.core.data.databaseService.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prilepskiy.core.data.databaseService.dao.CategoryDao
import com.prilepskiy.core.data.databaseService.dao.MealDao
import com.prilepskiy.core.data.databaseService.dao.MealInfoDao
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity
import com.prilepskiy.core.data.databaseService.entity.MealEntity
import com.prilepskiy.core.data.databaseService.entity.MealInfoEntity

@Database(
    entities = [CategoryEntity::class, MealEntity::class,MealInfoEntity::class] ,
    version = 1,
    exportSchema = true )

abstract class MainDatabase: RoomDatabase() {
    abstract val categoryDao: CategoryDao
    abstract val mealDao: MealDao
    abstract val mealInfoDao: MealInfoDao

}