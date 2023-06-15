package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.utils.ActionResult

interface GetCategoryNetworkUseCase {
    suspend operator fun invoke(): ActionResult<List<CategoryModel>>
}