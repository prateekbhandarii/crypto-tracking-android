package com.learn.crypto_tracker.crypto.domain

data class Coin (
    val id: String,
    val rank: Int,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercentageIn24Hr: Double
)