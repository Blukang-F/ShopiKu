package com.shopiku.data.model

data class Banner(
    val id: String = "",
    val imageUrl: String = "",
    val title: String = "",
    val subtitle: String = "",
    val actionUrl: String = ""
)

data class User(
    val id: String = "",
    val name: String = "Budi Santoso",
    val email: String = "budi@example.com",
    val phone: String = "081234567890",
    val avatarUrl: String = "",
    val token: String = ""
)
