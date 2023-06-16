package com.prilepskiy.core.di

import com.prilepskiy.core.presentation.HomeFragmentViewModel
import com.prilepskiy.core.presentation.ProfileFragmentViewModel
import com.prilepskiy.core.presentation.ShoppingBasketFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeFragmentViewModel(
        get(),
        get(),
        get(),
        get(),
        get(),
        get(),
        get()
    )
    }
    viewModel { ShoppingBasketFragmentViewModel() }
    viewModel { ProfileFragmentViewModel() }
}