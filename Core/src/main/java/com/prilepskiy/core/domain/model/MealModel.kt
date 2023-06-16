package com.prilepskiy.core.domain.model

import com.prilepskiy.core.data.apiService.response.categoryResponse.CategoryResponse
import com.prilepskiy.core.data.apiService.response.productResponse.MealResponse
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity
import com.prilepskiy.core.data.databaseService.entity.MealEntity

data class MealModel(
    val idMeal: Int,
    val strMeal: String,
    val strMealThumb: String,
    val categoryMeal: String,

) {
    companion object {
        fun from(
            data: MealResponse, categoryMeal: String

        ): MealModel = with(data) {
            MealModel(
                idMeal,
                strMeal,
                strMealThumb,
                categoryMeal)
        }

        fun from(data: MealEntity): MealModel = with(data) {
            MealModel(
                idMeal,
                strMeal,
                strMealThumb,
                categoryMeal,
            )
        }
    }
}