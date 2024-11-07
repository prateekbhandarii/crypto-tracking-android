package com.learn.crypto_tracker.crypto.presentation.coin_list

import com.learn.crypto_tracker.crypto.presentation.models.CoinUI

sealed interface CoinListAction {
    data class OnCoinClick(
        val coinUI: CoinUI
    ) : CoinListAction
}