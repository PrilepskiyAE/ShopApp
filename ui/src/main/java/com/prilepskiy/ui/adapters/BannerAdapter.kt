package com.prilepskiy.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.ui.R
import com.prilepskiy.ui.databinding.ItemBannerBinding
import com.prilepskiy.ui.databinding.ItemCategoryBinding

class BannerAdapter() : ListAdapter<String, BannerAdapter.BannerHolder>(ComporatorBanners()) {


    inner class BannerHolder(
        view: View,
    ) : RecyclerView.ViewHolder(view)
    {
        private val binding = ItemBannerBinding.bind(view)
        fun bind(data: String)  {

            with(binding){
               Glide.with(itemView)
                   .load(data)
                   .into(imLogo)

            }
        }


    }



    class ComporatorBanners : DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.length==newItem.length
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerHolder {

        val view=   LayoutInflater.from(parent.context).inflate(R.layout.item_banner, parent, false)

        return BannerHolder(view)
    }

    override fun onBindViewHolder(holder: BannerHolder, position: Int) {
        holder.bind(getItem(position))

    }



}