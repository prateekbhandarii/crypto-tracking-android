package com.learn.crypto_tracker.crypto.presentation.coin_list

import com.learn.crypto_tracker.core.domain.utils.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}