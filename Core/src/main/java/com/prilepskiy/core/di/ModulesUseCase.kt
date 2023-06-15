package com.prilepskiy.core.di

import com.prilepskiy.core.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.core.domain.interactors.GetCategoryNetworkUseCase
import com.prilepskiy.core.domain.interactors.GetProductCashUseCase
import com.prilepskiy.core.domain.interactors.GetProductInfoCashUseCase
import com.prilepskiy.core.domain.interactors.GetProductInfoNetworkUseCase
import com.prilepskiy.core.domain.interactors.GetProductNetworkUseCase
import com.prilepskiy.core.domain.usecase.GetCategoryCashUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetCategoryNetworkUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetProductCashUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetProductInfoCashUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetProductInfoNetworkUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetProductNetworkUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetCategoryCashUseCase> { GetCategoryCashUseCaseImpl(get()) }
    factory<GetCategoryNetworkUseCase> { GetCategoryNetworkUseCaseImpl(get()) }
    factory<GetProductCashUseCase> { GetProductCashUseCaseImpl(get()) }
    factory<GetProductInfoCashUseCase> { GetProductInfoCashUseCaseImpl(get()) }
    factory<GetProductInfoNetworkUseCase> { GetProductInfoNetworkUseCaseImpl(get()) }
    factory<GetProductNetworkUseCase> { GetProductNetworkUseCaseImpl(get()) }
}