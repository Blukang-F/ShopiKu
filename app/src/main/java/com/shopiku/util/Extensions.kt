package com.shopiku.util

import java.text.NumberFormat
import java.util.Locale

fun Long.toRupiah(): String {
    val formatter = NumberFormat.getNumberInstance(Locale("id", "ID"))
    return "Rp${formatter.format(this)}"
}

fun Int.toRupiah(): String = this.toLong().toRupiah()

fun Int.toSoldLabel(): String = when {
    this >= 1_000_000 -> "${String.format("%.1f", this / 1_000_000.0)}jt terjual"
    this >= 1_000 -> "${String.format("%.1f", this / 1_000.0)}rb terjual"
    else -> "$this terjual"
}
