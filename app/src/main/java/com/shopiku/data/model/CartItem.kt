package com.shopiku.data.model

data class CartItem(
    val id: String = "",
    val productId: String = "",
    val productName: String = "",
    val productImage: String = "",
    val variant: String = "",
    val price: Long = 0,
    var quantity: Int = 1,
    var isSelected: Boolean = true
)
