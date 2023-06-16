package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.MealInfoModel
import kotlinx.coroutines.flow.Flow


interface GetProductInfoCashUseCase {
    suspend operator fun invoke(id:String): Flow<List<MealInfoModel>>
}