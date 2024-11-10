package com.learn.crypto_tracker.di

import com.learn.crypto_tracker.core.data.networking.HttpClientFactory
import com.learn.crypto_tracker.crypto.data.networking.RemoteCoinDataSource
import com.learn.crypto_tracker.crypto.domain.CoinDataSource
import com.learn.crypto_tracker.crypto.presentation.coin_list.viewmodel.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    single { RemoteCoinDataSource(get()) }.bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)
}