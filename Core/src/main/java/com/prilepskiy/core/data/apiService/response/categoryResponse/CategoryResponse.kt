package com.prilepskiy.core.data.apiService.response.categoryResponse

import com.prilepskiy.core.data.databaseService.entity.CategoryEntity

data class CategoryResponse(
    val idCategory: Int=0,
    val strCategory: String="",
   // val strCategoryDescription: String?,
    val strCategoryThumb: String=""
)