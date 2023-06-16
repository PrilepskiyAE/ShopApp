package com.prilepskiy.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationBarView
import com.prilepskiy.ui.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var navController: NavController
    private lateinit var navHost: NavHostFragment
    lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navHost =
            childFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment
        navController = navHost.navController
        onBottomNavClicks()
    }

    private fun onBottomNavClicks() {
        binding.bottomNav.labelVisibilityMode = NavigationBarView.LABEL_VISIBILITY_LABELED
        binding.bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeFragment -> {
                    navController.popBackStack(R.id.homeFragment, false, saveState = true)
                }

                R.id.profileFragment -> {
                    navController.navigate(R.id.profileFragment, null)
                }

                R.id.shoppingBasketFragment -> {
                    navController.navigate(R.id.shoppingBasketFragment, null)
                }
            }
            true
        }
    }

    companion object {
        const val TAG = "MainFragment"
    }
}