package com.learn.crypto_tracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.learn.crypto_tracker.core.presentation.utils.ObserveAsEvents
import com.learn.crypto_tracker.core.presentation.utils.toString
import com.learn.crypto_tracker.crypto.presentation.coin_details.CoinDetailScreen
import com.learn.crypto_tracker.crypto.presentation.coin_list.CoinListEvent
import com.learn.crypto_tracker.crypto.presentation.coin_list.CoinListScreen
import com.learn.crypto_tracker.crypto.presentation.coin_list.CoinListViewModel
import com.learn.crypto_tracker.ui.theme.CryptoTrackerTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    val viewModel = koinViewModel<CoinListViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()

                    val context = LocalContext.current
                    ObserveAsEvents(events = viewModel.events) { events ->
                        when (events) {
                            is CoinListEvent.Error -> {
                                Toast.makeText(
                                    context,
                                    events.error.toString(context),
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                    }

                    when {
                        state.selectedCoin != null -> {
                            CoinDetailScreen(
                                state = state,
                                modifier = Modifier.padding(innerPadding)
                            )
                        }

                        else -> {
                            CoinListScreen(
                                state = state,
                                modifier = Modifier.padding(innerPadding),
                                onAction = viewModel::onAction
                            )
                        }
                    }
                }
            }
        }
    }
}