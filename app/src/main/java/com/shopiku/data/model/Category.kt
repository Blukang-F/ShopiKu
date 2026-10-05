package com.shopiku.data.model

data class Category(
    val id: String = "",
    val name: String = "",
    val iconRes: Int = 0,
    val subCategories: List<SubCategory> = emptyList()
)

data class SubCategory(
    val id: String = "",
    val name: String = "",
    val iconRes: Int = 0,
    val parentCategoryId: String = ""
)
