package com.prilepskiy.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.prilepskiy.core.presentation.ProfileFragmentViewModel
import com.prilepskiy.ui.databinding.FragmentProfileBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment :  BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {
    val viewModel: ProfileFragmentViewModel by viewModel()

}