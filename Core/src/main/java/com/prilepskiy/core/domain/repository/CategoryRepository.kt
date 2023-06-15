package com.prilepskiy.core.domain.repository

import com.prilepskiy.core.data.apiService.response.categoryResponse.CategoriesResponse
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity
import com.prilepskiy.core.utils.ActionResult
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategoryNetwork(): ActionResult<CategoriesResponse>
    suspend fun getCategoryCash(): Flow<List<CategoryEntity>>
}