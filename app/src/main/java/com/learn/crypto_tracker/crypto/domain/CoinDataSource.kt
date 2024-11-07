package com.learn.crypto_tracker.crypto.domain

import com.learn.crypto_tracker.core.domain.utils.NetworkError
import com.learn.crypto_tracker.core.domain.utils.Result

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}