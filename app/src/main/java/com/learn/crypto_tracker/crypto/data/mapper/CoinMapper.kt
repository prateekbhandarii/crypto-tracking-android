package com.learn.crypto_tracker.crypto.data.mapper

import com.learn.crypto_tracker.crypto.data.networking.dto.CoinDto
import com.learn.crypto_tracker.crypto.data.networking.dto.CoinPriceDto
import com.learn.crypto_tracker.crypto.domain.Coin
import com.learn.crypto_tracker.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercentageIn24Hr = changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice(): CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dataTime = Instant
            .ofEpochMilli(time)
            .atZone(ZoneId.of("UTC"))
    )
}