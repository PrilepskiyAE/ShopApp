package com.prilepskiy.core.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.core.data.apiService.response.categoryResponse.CategoryResponse

@Entity(tableName = "category_table")
data class CategoryEntity (
    @PrimaryKey(autoGenerate = true)
    val idCategory: Int,
    val strCategory: String,
    // val strCategoryDescription: String,
    val strCategoryThumb: String
){
    companion object{
        fun from(data : CategoryResponse):CategoryEntity= with(data){
            CategoryEntity(idCategory, strCategory, strCategoryThumb)
        }
    }
}