package com.demo.justworktimer.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


data class Dimensions(
    val small: Dp = 4.dp,
    val medium: Dp = 8.dp,
    val high: Dp = 16.dp,
    val bar: Dp = 60.dp,
    val doubleDigitMaxWidth: Dp = 40.dp
)

val LocalDimensions = staticCompositionLocalOf { Dimensions() }

val MaterialTheme.dimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalDimensions.current