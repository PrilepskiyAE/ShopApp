package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetProductCashUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.model.MealModel
import com.prilepskiy.core.domain.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetProductCashUseCaseImpl(private val repository: ProductRepository) : GetProductCashUseCase {
    override suspend operator fun invoke(categoryName: String): Flow<List<MealModel>> =
        withContext(Dispatchers.IO) {
            repository.getProductCash(categoryName).map { list ->
                val result: MutableList<MealModel> = mutableListOf()
                list.forEach { item ->
                   result.add( MealModel.from(item))
                }
                result
            }
        }
}