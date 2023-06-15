package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.ProductInfoModel
import com.prilepskiy.core.domain.model.ProductModel
import kotlinx.coroutines.flow.Flow

interface GetProductCashUseCase {
    suspend operator fun invoke(categoryName:String): Flow<List<ProductModel>>
}