package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetBannerTestUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

class GetBannerTestUseCaseImpl(): GetBannerTestUseCase {
    override suspend fun invoke(): Flow<List<String>> {
        val imitationResult= mutableListOf<List<String>>()
        imitationResult.add(listOf(
            "https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1Rk5LQ3UyYwC9rlKXvKvpjgbKaKTM5SRkZCeTgDn6uOyic"
            ,"https://i.mycdn.me/i?r=AzEPZsRbOZEKgBhR0XGMT1Rk0Shrjn8J51IYfAP64jZ0vKaKTM5SRkZCeTgDn6uOyic"
            ,"https://bobr.by/data/announcement/announcement341.jpg","https://m.pln24.ru/pictures/161031125146.jpg"))
        return imitationResult.asFlow()
    }
}