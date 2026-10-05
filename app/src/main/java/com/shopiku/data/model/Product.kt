package com.shopiku.data.model

data class Product(
    val id: String = "",
    val name: String = "",
    val price: Long = 0,
    val originalPrice: Long = 0,
    val discountPercent: Int = 0,
    val imageUrl: String = "",
    val images: List<String> = emptyList(),
    val rating: Float = 0f,
    val sold: Int = 0,
    val category: String = "",
    val description: String = "",
    val stock: Int = 0,
    val variants: List<ProductVariant> = emptyList()
)

data class ProductVariant(
    val name: String = "",
    val options: List<String> = emptyList()
)
