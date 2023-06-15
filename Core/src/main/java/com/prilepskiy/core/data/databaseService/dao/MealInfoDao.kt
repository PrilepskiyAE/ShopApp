package com.prilepskiy.core.data.databaseService.dao

import androidx.room.Dao
import com.prilepskiy.core.data.databaseService.entity.MealEntity
import com.prilepskiy.core.data.databaseService.entity.MealInfoEntity
@Dao
abstract class MealInfoDao: BaseDao<MealInfoEntity>() {
}