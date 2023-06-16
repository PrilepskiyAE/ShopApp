package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetProductInfoCashUseCase
import com.prilepskiy.core.domain.model.MealInfoModel
import com.prilepskiy.core.domain.model.MealModel
import com.prilepskiy.core.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetProductInfoCashUseCaseImpl(private val repository: ProductRepository) :
    GetProductInfoCashUseCase {
    override suspend operator fun invoke(id: String): Flow<List<MealInfoModel>> =
        withContext(Dispatchers.IO) {
            repository.getProductInfoCash(id).map { list ->
                val result: MutableList<MealInfoModel> = mutableListOf()
                list.forEach { item ->
                   result.add( MealInfoModel.from(item))
                }
                result
            }
        }
}