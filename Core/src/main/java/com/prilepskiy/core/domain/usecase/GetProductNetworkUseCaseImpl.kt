package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetProductNetworkUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.model.MealModel
import com.prilepskiy.core.domain.repository.ProductRepository
import com.prilepskiy.core.utils.ActionResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetProductNetworkUseCaseImpl(
    private val repository: ProductRepository
    ) :
    GetProductNetworkUseCase {
    override suspend operator fun invoke(categoryName: String): ActionResult<List<MealModel>> =
        withContext(
            Dispatchers.IO
        )
        {
            //val apiData = repository.getProductNetwork(categoryName)

          val result = mutableListOf<MealModel>()
//            return@withContext when (apiData) {
//                is ActionResult.Success -> {
//                    apiData.data.meals
//                        .onEach {
//                        result.add(MealModel.from(it,categoryName))
//                    }
                   ActionResult.Success(result)
//                }
//
//                is ActionResult.Error -> {
//                    ActionResult.Error(apiData.errors)
//                }
//            }
        }
}