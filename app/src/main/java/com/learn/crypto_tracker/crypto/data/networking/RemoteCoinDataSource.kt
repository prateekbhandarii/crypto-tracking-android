package com.learn.crypto_tracker.crypto.data.networking

import com.learn.crypto_tracker.core.data.networking.constructUrl
import com.learn.crypto_tracker.core.data.networking.safeCall
import com.learn.crypto_tracker.core.domain.utils.NetworkError
import com.learn.crypto_tracker.core.domain.utils.Result
import com.learn.crypto_tracker.core.domain.utils.map
import com.learn.crypto_tracker.crypto.data.mapper.toCoin
import com.learn.crypto_tracker.crypto.data.networking.dto.CoinResponseDto
import com.learn.crypto_tracker.crypto.domain.Coin
import com.learn.crypto_tracker.crypto.domain.CoinDataSource
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
) : CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map {
                it.toCoin()
            }
        }
    }
}