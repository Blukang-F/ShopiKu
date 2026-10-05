package com.shopiku.data.model

data class Review(
    val id: String = "",
    val productId: String = "",
    val userId: String = "",
    val userName: String = "",
    val userAvatar: String = "",
    val rating: Float = 5f,
    val comment: String = "",
    val photos: List<String> = emptyList(),
    val date: String = ""
)

data class ReviewSummary(
    val averageRating: Float = 0f,
    val totalReviews: Int = 0,
    val distribution: Map<Int, Int> = emptyMap() // star -> count
)
