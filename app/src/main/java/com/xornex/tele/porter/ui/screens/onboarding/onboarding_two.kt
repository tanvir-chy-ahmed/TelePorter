package com.xornex.tele.porter.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.R
import com.xornex.tele.porter.ui.screens.onboarding.widgets.CustomCard
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.util.Ratio


@Composable
fun OnboardingTwo() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(
                text = "Why Tele Porter?",
                color = Color(0xFFFAFAFA),
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                fontFamily = FontFamily.SansSerif
            )

            Spacer(Modifier.height(Ratio.h(0.04f)))

            CustomCard(
                title = "Forward OTP Instantly",
                subtitle = "Get your SMS verification codes and messages on Telegram without delay.",
                trailing = R.drawable.rocket
            )
            Spacer(modifier = Modifier.height(20.dp))

            CustomCard(
                title = "Works From Anywhere",
                subtitle = "Access your texts even when your Android phone is miles away.",
                trailing = R.drawable.cloud
            )
            Spacer(modifier = Modifier.height(20.dp))

            CustomCard(
                title = "Instant Forwading",
                subtitle = "Your SMS messages are forwarded to Telegram in a flash.",
                trailing = R.drawable.lightning

            )


        }
    }
}
