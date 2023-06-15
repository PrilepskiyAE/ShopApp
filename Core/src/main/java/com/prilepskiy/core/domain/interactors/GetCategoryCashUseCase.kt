package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.utils.ActionResult
import kotlinx.coroutines.flow.Flow

interface GetCategoryCashUseCase {
    suspend operator fun invoke(): Flow<List<CategoryModel>>
}