package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.MealModel
import com.prilepskiy.core.utils.ActionResult

interface GetProductNetworkUseCase {
    suspend operator fun invoke(categoryName:String): ActionResult<List<MealModel>>
}