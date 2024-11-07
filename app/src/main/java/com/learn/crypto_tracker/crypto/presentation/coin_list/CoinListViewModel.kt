package com.learn.crypto_tracker.crypto.presentation.coin_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learn.crypto_tracker.core.domain.utils.onError
import com.learn.crypto_tracker.core.domain.utils.onSuccess
import com.learn.crypto_tracker.crypto.domain.CoinDataSource
import com.learn.crypto_tracker.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CoinListViewModel(
    private val coinDataSource: CoinDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(CoinListState())
    val state = _state
        .onStart { loadCoins() }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            CoinListState()
        )

    fun onAction(action: CoinListAction){
        when(action){
            is CoinListAction.OnCoinClick -> {
                TODO()
            }
        }
    }

    private fun loadCoins() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            coinDataSource.getCoins().onSuccess { coins ->
                _state.update {
                    it.copy(isLoading = false, coins = coins.map {
                        it.toCoinUi()
                    })
                }
            }.onError { error ->
                _state.update {
                    it.copy(
                        isLoading = false
                    )
                }
            }
        }
    }
}