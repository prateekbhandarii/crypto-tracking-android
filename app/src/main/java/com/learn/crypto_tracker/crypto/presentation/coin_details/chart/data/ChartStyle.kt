package com.learn.crypto_tracker.crypto.presentation.coin_details.chart.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

data class ChartStyle(
    val chartLineColor: Color,
    val unselectedColor: Color,
    val selectedColor: Color,
    val helperLinesThicknessPx: Float,
    val axisLineThicknessPx: Float,
    val labelFontSize: TextUnit,
    val minYLabelSpacing: Dp,
    val verticalPadding: Dp,
    val horizontalPadding: Dp,
    val xAxisLabelSpacing: Dp
)