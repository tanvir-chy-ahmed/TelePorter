package com.xornex.tele.porter.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Ratio {

    @Composable
    fun h(percent: Float): Dp {
        val config = LocalConfiguration.current
        val total = config.screenHeightDp.dp
        return total * percent
    }

    @Composable
    fun w(percent: Float): Dp {
        val config = LocalConfiguration.current
        val total = config.screenWidthDp.dp
        return total * percent
    }
}
