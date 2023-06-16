package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetCategoryNetworkUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.repository.CategoryRepository
import com.prilepskiy.core.utils.ActionResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCategoryNetworkUseCaseImpl(private val repository: CategoryRepository) :
    GetCategoryNetworkUseCase {
    override suspend operator fun invoke(): ActionResult<List<CategoryModel>> = withContext(Dispatchers.IO) {
        val apiData = repository.getCategoryNetwork()
        val result = mutableListOf<CategoryModel>()
        return@withContext when (apiData) {
            is ActionResult.Success -> {
                apiData.data.categories.onEach {
                    result.add(CategoryModel.from(it))
                }
                ActionResult.Success(result)
            }

            is ActionResult.Error -> {
                ActionResult.Error(apiData.errors)
            }
        }
    }
}
