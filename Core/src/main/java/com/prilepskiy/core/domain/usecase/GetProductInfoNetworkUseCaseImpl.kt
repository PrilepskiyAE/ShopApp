package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetProductInfoNetworkUseCase
import com.prilepskiy.core.domain.model.MealInfoModel
import com.prilepskiy.core.domain.model.MealModel
import com.prilepskiy.core.domain.repository.ProductRepository
import com.prilepskiy.core.utils.ActionResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetProductInfoNetworkUseCaseImpl(private val repository: ProductRepository) :
    GetProductInfoNetworkUseCase {
    override suspend operator fun invoke(id: String): ActionResult<List<MealInfoModel>> = withContext(
        Dispatchers.IO
    ) {
        val apiData = repository.getProductInfoNetwork(id)

        val result = mutableListOf<MealInfoModel>()
        return@withContext when (apiData) {
            is ActionResult.Success -> {
                apiData.data.meals
                    .onEach {
                        result.add(MealInfoModel.from(it))
                    }
                ActionResult.Success(result)
            }

            is ActionResult.Error -> {
                ActionResult.Error(apiData.errors)
            }
        }
    }
}