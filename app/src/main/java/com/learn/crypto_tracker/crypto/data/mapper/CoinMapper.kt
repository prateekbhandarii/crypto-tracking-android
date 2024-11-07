package com.learn.crypto_tracker.crypto.data.mapper

import com.learn.crypto_tracker.crypto.data.networking.dto.CoinDto
import com.learn.crypto_tracker.crypto.domain.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercentageIn24Hr = changePercent24h
    )
}