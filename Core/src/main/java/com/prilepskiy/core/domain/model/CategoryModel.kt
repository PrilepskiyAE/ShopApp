package com.prilepskiy.core.domain.model

import androidx.room.PrimaryKey
import com.prilepskiy.core.data.apiService.response.categoryResponse.CategoryResponse
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity

data class CategoryModel(
    val idCategory: Int,
    val strCategory: String,
    // val strCategoryDescription: String,
    val strCategoryThumb: String,
    val isActive:Boolean=false
) {
    companion object {
        fun from(data: CategoryResponse): CategoryModel = with(data) {
            CategoryModel(idCategory, strCategory, strCategoryThumb)
        }

        fun from(data: CategoryEntity): CategoryModel = with(data) {
            CategoryModel(idCategory, strCategory, strCategoryThumb)
        }
    }
}
