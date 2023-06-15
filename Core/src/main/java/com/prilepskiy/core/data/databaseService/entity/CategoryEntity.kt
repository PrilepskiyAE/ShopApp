package com.prilepskiy.core.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class CategoryEntity (
    @PrimaryKey(autoGenerate = true)
    val idCategory: Int,
    val strCategory: String,
    // val strCategoryDescription: String,
    val strCategoryThumb: String
)