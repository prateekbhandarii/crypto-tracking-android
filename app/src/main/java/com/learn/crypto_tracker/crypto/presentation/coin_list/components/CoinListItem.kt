package com.learn.crypto_tracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.learn.crypto_tracker.crypto.presentation.models.CoinUI

@Composable
fun CoinListItem(
    coinUI: CoinUI,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp), //separates all components by 16dp
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = coinUI.iconRes),
            contentDescription = coinUI.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )
    }
}