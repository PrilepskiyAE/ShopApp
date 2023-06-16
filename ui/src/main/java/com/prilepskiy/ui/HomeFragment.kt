package com.prilepskiy.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.prilepskiy.core.presentation.HomeFragmentViewModel
import com.prilepskiy.ui.adapters.BannerAdapter
import com.prilepskiy.ui.adapters.CategoryAdapter
import com.prilepskiy.ui.adapters.MealAdapter
import com.prilepskiy.ui.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    val viewModel: HomeFragmentViewModel by viewModel()
    val categoryAdapter = CategoryAdapter {
        viewModel.getMeat(it.strCategory)
        viewModel.categoryModel.value?.let { it1 -> viewModel.activatioTeg(it, it1) }

    }
    val bannerAdapter = BannerAdapter()
    val mealAdapter = MealAdapter {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCategory()
        viewModel.getBanners()
        viewModel.getMeat("Beef")
        with(binding) {
            binding.rcBanner.adapter = bannerAdapter
            binding.rcCategory.adapter = categoryAdapter
            binding.rcMeal.adapter = mealAdapter
        }


        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.categoryModel.collect {
                categoryAdapter.submitList(it)

            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.bannerModel.collect {
                bannerAdapter.submitList(it)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.mealModel.collect {
                if (it.isNullOrEmpty()) {
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.GONE
                }
                mealAdapter.submitList(it)
            }
        }

    }
}