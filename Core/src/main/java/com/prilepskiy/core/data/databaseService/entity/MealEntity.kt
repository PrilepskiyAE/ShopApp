package com.prilepskiy.core.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "meal_table")

data class MealEntity (
    @PrimaryKey(autoGenerate = true)
    val idMeal: Int,
    val strMeal: String,
    val strMealThumb: String
)