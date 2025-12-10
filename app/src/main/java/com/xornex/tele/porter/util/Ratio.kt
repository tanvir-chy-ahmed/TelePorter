package com.xornex.tele.porter.util

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Ratio {

    @SuppressLint("ConfigurationScreenWidthHeight")
    @Composable
    fun h(percent: Float): Dp {
        val config = LocalConfiguration.current
        val total = config.screenHeightDp.dp
        return total * percent
    }

    @SuppressLint("ConfigurationScreenWidthHeight")
    @Composable
    fun w(percent: Float): Dp {
        val config = LocalConfiguration.current
        val total = config.screenWidthDp.dp
        return total * percent
    }
}
