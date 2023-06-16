package com.prilepskiy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.ui.R
import com.prilepskiy.ui.databinding.ItemCategoryBinding

class CategoryAdapter(private val onClickButtonClicked: (data:CategoryModel) -> Unit) :
    ListAdapter<CategoryModel, CategoryAdapter.TagHolder>(ComporatorCategory()) {


    inner class TagHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view)
    {
        private val binding = ItemCategoryBinding.bind(view)
        fun bind(data: CategoryModel)  {

            with(binding){
                button.text=data.strCategory
                button.setOnClickListener {
                    onClickButtonClicked(data)
                }
            }
        }


    }



    class ComporatorCategory : DiffUtil.ItemCallback<CategoryModel>(){
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem.strCategory==newItem.strCategory
        }

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagHolder {

        val view=  when(viewType){
            CATEGORY_ACTIVE-> LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category_active, parent, false)
            CATEGORY_PASSIVE-> LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false)

            else -> {throw RuntimeException("Unknown view type: $viewType")}}

        return TagHolder(view)
    }

    override fun onBindViewHolder(holder: TagHolder, position: Int) {
        holder.bind(getItem(position))

    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.isActive){
            CATEGORY_ACTIVE
        }else{
            CATEGORY_PASSIVE
        }
    }


    companion object{
        const val CATEGORY_PASSIVE=200
        const val CATEGORY_ACTIVE=201

    }
}