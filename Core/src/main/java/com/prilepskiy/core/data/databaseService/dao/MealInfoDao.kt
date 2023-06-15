package com.prilepskiy.core.data.databaseService.dao

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.core.data.databaseService.entity.MealInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class MealInfoDao: BaseDao<MealInfoEntity>() {
    @Query("SELECT * FROM meal_info_table WHERE idMeal=:id ")
    abstract fun getMealInfo(id:Int): Flow<List<MealInfoEntity>>
}