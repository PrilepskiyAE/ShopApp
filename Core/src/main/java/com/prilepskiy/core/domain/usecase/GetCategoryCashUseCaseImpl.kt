package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetCategoryCashUseCaseImpl(private val repository: CategoryRepository) :
    GetCategoryCashUseCase {
    override suspend fun invoke(): Flow<List<CategoryModel>> = withContext(Dispatchers.IO) {
        repository.getCategoryCash().map { list ->
            val result: MutableList<CategoryModel> = mutableListOf()
            list.forEach { item ->
                CategoryModel.from(item)
            }
            result
        }
    }
}