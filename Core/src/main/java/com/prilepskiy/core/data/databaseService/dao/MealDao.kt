package com.prilepskiy.core.data.databaseService.dao

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity
import com.prilepskiy.core.data.databaseService.entity.MealEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MealDao: BaseDao<MealEntity>() {
    @Query("SELECT * FROM meal_table WHERE categoryMeal=:categoryName")
    abstract fun getMeal(categoryName:String): Flow<List<MealEntity>>
}