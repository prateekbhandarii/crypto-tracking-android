package com.learn.crypto_tracker.core.presentation.utils

import android.content.Context
import com.learn.crypto_tracker.R
import com.learn.crypto_tracker.core.domain.utils.NetworkError

fun NetworkError.toString(context: Context): String {
    val res = when (this) {
        NetworkError.REQUEST_TIMEOUT -> R.string.error_request_timeout
        NetworkError.TOO_MANY_REQUEST -> R.string.error_too_many_request
        NetworkError.NO_INTERNET -> R.string.error_no_internet
        NetworkError.SERVER_ERROR -> R.string.error_unknown
        NetworkError.SERIALIZATION_ERROR -> R.string.error_serialization
        NetworkError.UNKNOWN -> R.string.error_unknown
    }

    return context.getString(res)
}