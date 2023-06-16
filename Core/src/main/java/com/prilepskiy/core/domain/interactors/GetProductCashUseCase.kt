package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.MealModel
import kotlinx.coroutines.flow.Flow

interface GetProductCashUseCase {
    suspend operator fun invoke(categoryName:String): Flow<List<MealModel>>
}