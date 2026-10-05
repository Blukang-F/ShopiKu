package com.shopiku.data.model

data class Order(
    val id: String = "",
    val items: List<CartItem> = emptyList(),
    val shippingAddress: Address = Address(),
    val shippingMethod: String = "Reguler",
    val shippingCost: Long = 15000,
    val paymentMethod: String = "Transfer Bank",
    val subtotal: Long = 0,
    val total: Long = 0,
    val status: OrderStatus = OrderStatus.PENDING_PAYMENT,
    val virtualAccount: String = "123 456 7890",
    val trackingNumber: String = "",
    val courier: String = "JNE",
    val timeline: List<TrackingEvent> = emptyList(),
    val createdAt: String = ""
)

data class Address(
    val name: String = "Budi Santoso",
    val phone: String = "081234567890",
    val address: String = "Jl. Siliwangi No. 123",
    val city: String = "Cirebon",
    val province: String = "Jawa Barat",
    val postalCode: String = "45112"
)

data class TrackingEvent(
    val date: String = "",
    val time: String = "",
    val description: String = "",
    val location: String = ""
)

enum class OrderStatus {
    PENDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED, COMPLETED, EXPIRED
}
