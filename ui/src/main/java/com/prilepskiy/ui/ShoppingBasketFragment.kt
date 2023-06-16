package com.prilepskiy.ui

import com.prilepskiy.core.presentation.ShoppingBasketFragmentViewModel

import com.prilepskiy.ui.databinding.FragmentShoppingBasketBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class ShoppingBasketFragment :
    BaseFragment<FragmentShoppingBasketBinding>(FragmentShoppingBasketBinding::inflate) {
    val viewModel: ShoppingBasketFragmentViewModel by viewModel()


}