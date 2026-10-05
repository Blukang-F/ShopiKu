package com.shopiku.data.repository

import com.shopiku.data.model.*
import kotlinx.coroutines.delay

/**
 * MockRepository — semua data dummy, tidak perlu network.
 * Dipakai selama API belum siap.
 */
object MockRepository {

    // ── Produk ──────────────────────────────────────────────────────────────

    private val PRODUCTS = listOf(
        Product(
            id = "p1",
            name = "TWS Earbuds Pro X - True Wireless Bluetooth 5.3",
            price = 189_000,
            originalPrice = 350_000,
            discountPercent = 46,
            imageUrl = "https://images.unsplash.com/photo-1590658268037-6bf12165a8df?w=400",
            images = listOf(
                "https://images.unsplash.com/photo-1590658268037-6bf12165a8df?w=400",
                "https://images.unsplash.com/photo-1608043152269-423dbba4e7e1?w=400"
            ),
            rating = 4.7f,
            sold = 12_400,
            category = "Elektronik",
            description = "TWS Earbuds dengan koneksi Bluetooth 5.3, noise cancellation aktif, baterai 8 jam + case 32 jam. Cocok untuk aktivitas sehari-hari.",
            stock = 150,
            variants = listOf(ProductVariant("Warna", listOf("Hitam", "Putih", "Biru")))
        ),
        Product(
            id = "p2",
            name = "Samsung Galaxy A54 5G 8/256GB - Garansi Resmi",
            price = 4_599_000,
            originalPrice = 5_499_000,
            discountPercent = 16,
            imageUrl = "https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=400",
            images = listOf(
                "https://images.unsplash.com/photo-1610945265064-0e34e5519bbf?w=400",
                "https://images.unsplash.com/photo-1592899677977-9c10ca588bbd?w=400"
            ),
            rating = 4.8f,
            sold = 3_200,
            category = "Elektronik",
            description = "Samsung Galaxy A54 5G layar Super AMOLED 6.4\" FHD+, kamera 50MP OIS, baterai 5000mAh, chipset Exynos 1380.",
            stock = 80,
            variants = listOf(
                ProductVariant("Warna", listOf("Awesome Graphite", "Awesome White", "Awesome Lime")),
                ProductVariant("Storage", listOf("8/128GB", "8/256GB"))
            )
        ),
        Product(
            id = "p3",
            name = "Apple iPhone 15 128GB - Resmi iBox",
            price = 13_999_000,
            originalPrice = 15_999_000,
            discountPercent = 12,
            imageUrl = "https://images.unsplash.com/photo-1695048133142-1a20484d2569?w=400",
            images = listOf(
                "https://images.unsplash.com/photo-1695048133142-1a20484d2569?w=400",
                "https://images.unsplash.com/photo-1574755393849-623942496936?w=400"
            ),
            rating = 4.9f,
            sold = 1_850,
            category = "Elektronik",
            description = "iPhone 15 dengan chip A16 Bionic, layar Super Retina XDR 6.1\", sistem kamera 48MP, USB-C, Dynamic Island.",
            stock = 40,
            variants = listOf(
                ProductVariant("Warna", listOf("Black", "Blue", "Green", "Yellow", "Pink")),
                ProductVariant("Storage", listOf("128GB", "256GB", "512GB"))
            )
        ),
        Product(
            id = "p4",
            name = "ASUS VivoBook 14 Laptop AMD Ryzen 5 8GB/512GB SSD",
            price = 7_299_000,
            originalPrice = 9_500_000,
            discountPercent = 23,
            imageUrl = "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400",
            images = listOf(
                "https://images.unsplash.com/photo-1496181133206-80ce9b88a853?w=400",
                "https://images.unsplash.com/photo-1525547719571-a2d4ac8945e2?w=400"
            ),
            rating = 4.6f,
            sold = 720,
            category = "Elektronik",
            description = "ASUS VivoBook 14 dengan AMD Ryzen 5 5500U, RAM 8GB DDR4, SSD 512GB NVMe, layar FHD IPS 14\", Windows 11 Home.",
            stock = 30,
            variants = listOf(
                ProductVariant("Warna", listOf("Transparent Silver", "Indie Black")),
                ProductVariant("RAM", listOf("8GB", "16GB"))
            )
        ),
        Product(
            id = "p5",
            name = "Smartwatch Xiaomi Mi Band 8 - Sport Edition",
            price = 429_000,
            originalPrice = 599_000,
            discountPercent = 28,
            imageUrl = "https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400",
            images = listOf("https://images.unsplash.com/photo-1523275335684-37898b6baf30?w=400"),
            rating = 4.5f,
            sold = 8_900,
            category = "Elektronik",
            description = "Xiaomi Mi Band 8 dengan layar AMOLED 1.62\", 150+ mode olahraga, sensor detak jantung, SpO2, baterai 16 hari.",
            stock = 200,
            variants = listOf(ProductVariant("Warna", listOf("Hitam", "Orange", "Biru")))
        ),
        Product(
            id = "p6",
            name = "Kemeja Batik Pria Slim Fit Motif Parang Premium",
            price = 145_000,
            originalPrice = 220_000,
            discountPercent = 34,
            imageUrl = "https://images.unsplash.com/photo-1607082348824-0a96f2a4b9da?w=400",
            images = listOf("https://images.unsplash.com/photo-1607082348824-0a96f2a4b9da?w=400"),
            rating = 4.4f,
            sold = 2_100,
            category = "Fashion",
            description = "Kemeja batik pria bahan katun premium, motif parang, slim fit, tersedia berbagai ukuran.",
            stock = 500,
            variants = listOf(
                ProductVariant("Ukuran", listOf("S", "M", "L", "XL", "XXL")),
                ProductVariant("Warna", listOf("Coklat", "Biru", "Hijau"))
            )
        ),
        Product(
            id = "p7",
            name = "Sepatu Sneakers Pria Running Casual Sport",
            price = 299_000,
            originalPrice = 450_000,
            discountPercent = 33,
            imageUrl = "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400",
            images = listOf("https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=400"),
            rating = 4.6f,
            sold = 4_300,
            category = "Fashion",
            description = "Sepatu sneakers pria material mesh breathable, sol karet anti-slip, cocok untuk olahraga dan casual.",
            stock = 300,
            variants = listOf(ProductVariant("Ukuran", listOf("39", "40", "41", "42", "43", "44")))
        ),
        Product(
            id = "p8",
            name = "Serum Vitamin C 20% Brightening & Anti-Aging",
            price = 89_000,
            originalPrice = 150_000,
            discountPercent = 41,
            imageUrl = "https://images.unsplash.com/photo-1556228578-8c89e6adf883?w=400",
            images = listOf("https://images.unsplash.com/photo-1556228578-8c89e6adf883?w=400"),
            rating = 4.7f,
            sold = 15_600,
            category = "Kecantikan",
            description = "Serum wajah Vitamin C 20% mencerahkan kulit, mengurangi noda hitam, anti-aging, cocok semua jenis kulit.",
            stock = 1000,
            variants = listOf(ProductVariant("Ukuran", listOf("30ml", "50ml")))
        )
    )

    // ── Kategori ─────────────────────────────────────────────────────────────

    val CATEGORIES = listOf(
        Category("c1", "Elektronik", 0, listOf(
            SubCategory("sc1", "Smartphone", 0, "c1"),
            SubCategory("sc2", "Laptop", 0, "c1"),
            SubCategory("sc3", "Aksesoris HP", 0, "c1"),
            SubCategory("sc4", "Smartwatch", 0, "c1")
        )),
        Category("c2", "Fashion Pria", 0, listOf(
            SubCategory("sc5", "Kemeja", 0, "c2"),
            SubCategory("sc6", "Celana", 0, "c2"),
            SubCategory("sc7", "Sepatu", 0, "c2")
        )),
        Category("c3", "Fashion Wanita", 0, listOf(
            SubCategory("sc8", "Dress", 0, "c3"),
            SubCategory("sc9", "Tas", 0, "c3"),
            SubCategory("sc10", "Sepatu Wanita", 0, "c3")
        )),
        Category("c4", "Kecantikan", 0, listOf(
            SubCategory("sc11", "Skincare", 0, "c4"),
            SubCategory("sc12", "Makeup", 0, "c4"),
            SubCategory("sc13", "Parfum", 0, "c4")
        )),
        Category("c5", "Ibu & Bayi", 0, listOf(
            SubCategory("sc14", "Perlengkapan Bayi", 0, "c5"),
            SubCategory("sc15", "Mainan Anak", 0, "c5")
        )),
        Category("c6", "Rumah Tangga", 0, listOf(
            SubCategory("sc16", "Dapur", 0, "c6"),
            SubCategory("sc17", "Dekorasi", 0, "c6")
        )),
        Category("c7", "Makanan & Minuman", 0, listOf(
            SubCategory("sc18", "Snack", 0, "c7"),
            SubCategory("sc19", "Minuman", 0, "c7")
        )),
        Category("c8", "Olahraga & Outdoor", 0, listOf(
            SubCategory("sc20", "Fitness", 0, "c8"),
            SubCategory("sc21", "Outdoor", 0, "c8")
        )),
        Category("c9", "Otomotif", 0, listOf(
            SubCategory("sc22", "Aksesoris Motor", 0, "c9"),
            SubCategory("sc23", "Aksesoris Mobil", 0, "c9")
        )),
        Category("c10", "Kesehatan", 0, listOf(
            SubCategory("sc24", "Suplemen", 0, "c10"),
            SubCategory("sc25", "Alat Kesehatan", 0, "c10")
        )),
        Category("c11", "Buku & Alat Tulis", 0, listOf(
            SubCategory("sc26", "Buku", 0, "c11"),
            SubCategory("sc27", "Alat Tulis", 0, "c11")
        ))
    )

    // ── Banners ──────────────────────────────────────────────────────────────

    val BANNERS = listOf(
        Banner("b1", "https://images.unsplash.com/photo-1607082348824-0a96f2a4b9da?w=800", "Flash Sale", "Diskon hingga 70%", ""),
        Banner("b2", "https://images.unsplash.com/photo-1556742049-0cfed4f6a45d?w=800", "Gratis Ongkir", "Untuk semua produk hari ini", ""),
        Banner("b3", "https://images.unsplash.com/photo-1563013544-824ae1b704d3?w=800", "Voucher Cashback", "Klaim cashback Rp50.000", "")
    )

    // ── Cart (in-memory) ─────────────────────────────────────────────────────

    private val _cart = mutableListOf<CartItem>()

    // ── Reviews ──────────────────────────────────────────────────────────────

    private val REVIEWS = listOf(
        Review("r1", "p1", "u1", "Ahmad Fauzi", "", 5f, "Kualitas suara jernih, bass mantap! Sangat puas dengan produknya.", emptyList(), "02 Okt 2026"),
        Review("r2", "p1", "u2", "Siti Rahayu", "", 4f, "Produk sesuai deskripsi, pengiriman cepat. Recommended!", emptyList(), "01 Okt 2026"),
        Review("r3", "p2", "u3", "Budi Prasetyo", "", 5f, "Samsung A54 baterai awet banget, kamera juga bagus.", emptyList(), "30 Sep 2026"),
        Review("r4", "p3", "u4", "Dewi Anggraini", "", 5f, "iPhone 15 kameranya keren, Dynamic Island seru dipakai!", emptyList(), "28 Sep 2026"),
        Review("r5", "p4", "u5", "Rizky Maulana", "", 4f, "Laptop ASUS kenceng buat kerjaan sehari-hari, build quality oke.", emptyList(), "25 Sep 2026")
    )

    // ── API Simulation Functions ─────────────────────────────────────────────

    suspend fun getProducts(search: String = "", category: String = ""): List<Product> {
        delay(600) // simulate network delay
        return PRODUCTS.filter { product ->
            (search.isEmpty() || product.name.contains(search, ignoreCase = true)) &&
            (category.isEmpty() || product.category.equals(category, ignoreCase = true))
        }
    }

    suspend fun getProductById(id: String): Product? {
        delay(300)
        return PRODUCTS.find { it.id == id }
    }

    suspend fun getFlashSaleProducts(): List<Product> {
        delay(400)
        return PRODUCTS.filter { it.discountPercent >= 20 }.take(5)
    }

    suspend fun getRecommendedProducts(): List<Product> {
        delay(400)
        return PRODUCTS.shuffled()
    }

    suspend fun login(email: String, password: String): String {
        delay(800)
        if (email.isBlank() || password.isBlank()) throw Exception("Email dan password tidak boleh kosong")
        if (password.length < 6) throw Exception("Password minimal 6 karakter")
        return "mock_token_${System.currentTimeMillis()}"
    }

    suspend fun register(name: String, email: String, password: String): String {
        delay(1000)
        return "mock_token_${System.currentTimeMillis()}"
    }

    suspend fun getCart(): List<CartItem> {
        delay(300)
        return _cart.toList()
    }

    suspend fun addToCart(item: CartItem): Boolean {
        delay(400)
        val existing = _cart.find { it.productId == item.productId && it.variant == item.variant }
        if (existing != null) {
            existing.quantity += item.quantity
        } else {
            _cart.add(item.copy(id = "cart_${System.currentTimeMillis()}"))
        }
        return true
    }

    suspend fun updateCartQty(cartId: String, qty: Int): Boolean {
        delay(200)
        val item = _cart.find { it.id == cartId } ?: return false
        if (qty <= 0) _cart.remove(item) else item.quantity = qty
        return true
    }

    suspend fun removeFromCart(cartId: String): Boolean {
        delay(200)
        return _cart.removeIf { it.id == cartId }
    }

    suspend fun checkout(items: List<CartItem>, address: Any, shipping: String, payment: String): Order {
        delay(1000)
        val subtotal = items.sumOf { it.price * it.quantity }
        val shippingCost = if (shipping == "Express") 25_000L else 15_000L
        return Order(
            id = "ORD${System.currentTimeMillis()}",
            items = items,
            shippingMethod = shipping,
            shippingCost = shippingCost,
            paymentMethod = payment,
            subtotal = subtotal,
            total = subtotal + shippingCost,
            status = OrderStatus.PENDING_PAYMENT,
            virtualAccount = "123 456 7890",
            createdAt = java.text.SimpleDateFormat("dd MMM yyyy HH:mm", java.util.Locale("id")).format(java.util.Date())
        )
    }

    suspend fun simulatePayment(orderId: String): String {
        delay(1500)
        return "LUNAS"
    }

    suspend fun getOrderStatus(orderId: String): OrderStatus {
        delay(500)
        return OrderStatus.SHIPPED
    }

    suspend fun getTrackingEvents(orderId: String): List<TrackingEvent> {
        delay(400)
        return listOf(
            TrackingEvent("02 Okt 2026", "09:30", "Pesanan telah dibuat", "Cirebon"),
            TrackingEvent("02 Okt 2026", "11:00", "Pesanan sedang dikemas oleh penjual", "Cirebon"),
            TrackingEvent("02 Okt 2026", "14:00", "Paket diterima oleh JNE", "Cirebon"),
            TrackingEvent("02 Okt 2026", "16:30", "Paket sedang dalam perjalanan", "Cirebon"),
            TrackingEvent("03 Okt 2026", "08:00", "Paket tiba di sorting center", "Bandung")
        )
    }

    suspend fun getReviews(productId: String): List<Review> {
        delay(400)
        return REVIEWS.filter { it.productId == productId }.ifEmpty { REVIEWS.take(3) }
    }

    suspend fun getReviewSummary(productId: String): ReviewSummary {
        delay(300)
        val reviews = REVIEWS.filter { it.productId == productId }.ifEmpty { REVIEWS.take(3) }
        val avg = if (reviews.isEmpty()) 4.8f else reviews.map { it.rating }.average().toFloat()
        val dist = (1..5).associateWith { star -> reviews.count { it.rating.toInt() == star } }
        return ReviewSummary(avg, reviews.size, dist)
    }

    suspend fun submitReview(review: Review): Boolean {
        delay(800)
        return true
    }
}
