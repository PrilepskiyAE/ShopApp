package com.prilepskiy.core.data.repository

import com.prilepskiy.core.data.apiService.CategoryApiService
import com.prilepskiy.core.data.apiService.ProductApiService
import com.prilepskiy.core.data.apiService.response.productResponse.ProductInfoResponse
import com.prilepskiy.core.data.apiService.response.productResponse.ProductResponse
import com.prilepskiy.core.data.databaseService.database.MainDatabase
import com.prilepskiy.core.data.databaseService.entity.MealEntity
import com.prilepskiy.core.data.databaseService.entity.MealInfoEntity
import com.prilepskiy.core.domain.repository.ProductRepository
import com.prilepskiy.core.utils.ActionResult
import com.prilepskiy.core.utils.analyzeResponse
import com.prilepskiy.core.utils.makeApiCall
import kotlinx.coroutines.flow.Flow

class ProductRepositoryImpl(private val api: ProductApiService, private val db: MainDatabase) :
    ProductRepository {
    override suspend fun getProductNetwork(categoryName: String): ActionResult<ProductResponse> {
        val apiData = makeApiCall {
            analyzeResponse(api.getProductInfoByCategory(categoryName))
        }
        return when (apiData) {
            is ActionResult.Success -> {

                apiData.data.meals.onEach {
                    db.mealDao.insert(MealEntity.from(it, categoryName))
                }
                ActionResult.Success(apiData.data)
            }

            is ActionResult.Error -> {
                ActionResult.Error(apiData.errors)
            }
        }
    }

    override suspend fun getProductCash(categoryName: String): Flow<List<MealEntity>> =
        db.mealDao.getMeal(categoryName)

    override suspend fun getProductInfoNetwork(id: String): ActionResult<ProductInfoResponse> {
        val apiData = makeApiCall {
            analyzeResponse(api.getProductInfoByID(id))
        }
        return when (apiData) {
            is ActionResult.Success -> {

                apiData.data.meals.onEach {
                    db.mealInfoDao.insert(MealInfoEntity.from(it))
                }
                ActionResult.Success(apiData.data)
            }

            is ActionResult.Error -> {
                ActionResult.Error(apiData.errors)
            }
        }
    }

    override suspend fun getProductInfoCash(id: String): Flow<List<MealInfoEntity>> =
        db.mealInfoDao.getMealInfo(id.toInt())
}