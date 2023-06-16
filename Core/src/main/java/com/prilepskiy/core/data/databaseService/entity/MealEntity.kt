package com.prilepskiy.core.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.core.data.apiService.response.productResponse.MealResponse

@Entity(tableName = "meal_table")

data class MealEntity(
    @PrimaryKey(autoGenerate = true)
    val idMeal: Int,
    val strMeal: String,
    val strMealThumb: String,
    val categoryMeal: String,


) {
    companion object {
        fun from(
            data: MealResponse, categoryMeal: String



        ): MealEntity = with(data) {
            MealEntity(
                idMeal,
                strMeal,
                strMealThumb,
                categoryMeal,


            )
        }
    }
}