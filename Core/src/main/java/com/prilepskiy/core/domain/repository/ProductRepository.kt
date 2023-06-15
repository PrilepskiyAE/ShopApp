package com.prilepskiy.core.domain.repository

import com.prilepskiy.core.data.apiService.response.categoryResponse.CategoriesResponse
import com.prilepskiy.core.data.apiService.response.productResponse.ProductInfoResponse
import com.prilepskiy.core.data.apiService.response.productResponse.ProductResponse
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity
import com.prilepskiy.core.data.databaseService.entity.MealEntity
import com.prilepskiy.core.data.databaseService.entity.MealInfoEntity
import com.prilepskiy.core.utils.ActionResult
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProductNetwork(categoryName:String): ActionResult<ProductResponse>
    suspend fun getProductCash(categoryName:String): Flow<List<MealEntity>>

    suspend fun getProductInfoNetwork(id:String): ActionResult<ProductInfoResponse>
    suspend fun getProductInfoCash(id:String): Flow<List<MealInfoEntity>>
}