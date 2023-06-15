package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.ProductInfoModel
import com.prilepskiy.core.utils.ActionResult

interface GetProductInfoNetworkUseCase {
    suspend operator fun invoke(id:String): ActionResult<List<ProductInfoModel>>
}