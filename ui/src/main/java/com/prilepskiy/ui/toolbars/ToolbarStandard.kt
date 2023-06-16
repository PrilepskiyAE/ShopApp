package com.prilepskiy.ui.toolbars

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.prilepskiy.ui.databinding.ToolbarStandardBinding

class ToolbarStandard @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : ConstraintLayout(context, attrs) {
    private lateinit var binding: ToolbarStandardBinding


    init {
        createToolbar()
    }

    private fun createToolbar() {
        binding = ToolbarStandardBinding.inflate(LayoutInflater.from(context), this, false)
        addView(binding.root)

    }

    fun setTitleText(text: String) {
        binding.ToolbarTitle.text = text
    }


}