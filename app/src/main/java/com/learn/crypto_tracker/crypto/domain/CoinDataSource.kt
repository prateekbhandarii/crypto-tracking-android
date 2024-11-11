package com.learn.crypto_tracker.crypto.domain

import com.learn.crypto_tracker.core.domain.utils.NetworkError
import com.learn.crypto_tracker.core.domain.utils.Result
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}