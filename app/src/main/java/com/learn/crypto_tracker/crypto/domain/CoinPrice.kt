package com.learn.crypto_tracker.crypto.domain

import java.time.ZonedDateTime

data class CoinPrice(
    val priceUsd: Double,
    val dataTime: ZonedDateTime
)
