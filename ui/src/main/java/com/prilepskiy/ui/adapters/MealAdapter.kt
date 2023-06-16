package com.prilepskiy.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.model.MealModel
import com.prilepskiy.ui.R
import com.prilepskiy.ui.databinding.ItemCategoryBinding
import com.prilepskiy.ui.databinding.ItemMealBinding

class MealAdapter(private val onClickButtonClicked: (data: MealModel) -> Unit) :
    ListAdapter<MealModel, MealAdapter.MealHolder>(ComporatorMeal()) {


    inner class MealHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view) {
        private val binding = ItemMealBinding.bind(view)
        fun bind(data: MealModel) {

            with(binding) {
                tvTitle.text = data.strMeal
                Glide.with(itemView)
                    .load(data.strMealThumb)
                    .into(imgLogo)

                val result = StringBuffer()
                result.append(view.context.getString(R.string.texLabel))
                tvLabel.text = result
                binding.cardMeal.setOnClickListener {
                    onClickButtonClicked(data)
                }
            }


        }


    }


    class ComporatorMeal : DiffUtil.ItemCallback<MealModel>() {
        override fun areItemsTheSame(oldItem: MealModel, newItem: MealModel): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: MealModel, newItem: MealModel): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)


        return MealHolder(view)
    }

    override fun onBindViewHolder(holder: MealHolder, position: Int) {
        holder.bind(getItem(position))

    }


}