package com.xornex.tele.porter.ui.screens.onboarding.controller

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun PageIndicator(
    pageSize: Int,
    currentPage: Int, selectedColor: Color = Color(0xFF0da6f2),unselectedColor : Color = Color(0xFF0f374b)
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(pageSize) {
            Spacer(Modifier.size(2.5.dp))
            Box(Modifier
                .height(14.dp)
                .width(if(it==currentPage) 24.dp else 16.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color = if(it == currentPage) selectedColor else unselectedColor)

            ) {

            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ShowPreview(modifier: Modifier = Modifier) {
    PageIndicator(pageSize = 3, currentPage = 0)
}