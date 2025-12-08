package com.xornex.tele.porter.ui.screens.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.xornex.tele.porter.R
import com.xornex.tele.porter.ui.screens.onboarding.widgets.CustomCard2
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.ui.theme.ButtonColor
import com.xornex.tele.porter.util.Ratio
import com.xornex.tele.porter.util.Routes

@Composable
fun OnboardingThree() {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(16.dp)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(Ratio.h(0.001f)))

            Text(
                text = "What Tele Porter Offers",
                color = Color(0xFFFAFAFA),
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                fontFamily = FontFamily.SansSerif
            )

            Spacer(Modifier.height(Ratio.h(0.04f)))

            CustomCard2(
                title = "Smart Notification Hub",
                subtitle = "Your important messages get delivered to Telegram automatically, no extra effort.",
                trailing = R.drawable.flash
            )
            Spacer(modifier = Modifier.height(20.dp))

            CustomCard2(
                title = "Never Miss Anything",
                subtitle = "All SMS alerts, promotions, and OTPs appear in one place, instantly.",
                trailing = R.drawable.protect
            )
            Spacer(modifier = Modifier.height(20.dp))

            CustomCard2(
                title = "Secure & Private",
                subtitle = "Your messages are forwarded safely with full privacy protection.",
                trailing = R.drawable.unlock_ic
            )

        }
    }
}