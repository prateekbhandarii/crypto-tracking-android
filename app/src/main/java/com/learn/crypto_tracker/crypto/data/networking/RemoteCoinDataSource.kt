package com.learn.crypto_tracker.crypto.data.networking

import com.learn.crypto_tracker.core.data.networking.constructUrl
import com.learn.crypto_tracker.core.data.networking.safeCall
import com.learn.crypto_tracker.core.domain.utils.NetworkError
import com.learn.crypto_tracker.core.domain.utils.Result
import com.learn.crypto_tracker.core.domain.utils.map
import com.learn.crypto_tracker.crypto.data.mapper.toCoin
import com.learn.crypto_tracker.crypto.data.mapper.toCoinPrice
import com.learn.crypto_tracker.crypto.data.networking.dto.CoinHistoryDto
import com.learn.crypto_tracker.crypto.data.networking.dto.CoinResponseDto
import com.learn.crypto_tracker.crypto.domain.Coin
import com.learn.crypto_tracker.crypto.domain.CoinDataSource
import com.learn.crypto_tracker.crypto.domain.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

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

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()


        return safeCall<CoinHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history")
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
            response.data.map { it.toCoinPrice() }
        }
    }
}