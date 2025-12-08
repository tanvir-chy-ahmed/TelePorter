@file:Suppress("COMPOSE_APPLIER_CALL_MISMATCH")

package com.xornex.tele.porter.ui.screens.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.R
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.ui.theme.SkiptxtColor
import com.xornex.tele.porter.util.Ratio

@Composable
fun OnboardingOne(
    onSkipClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        /** ---------- Skip Button Row ---------- */
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Skip for now",
                fontWeight = FontWeight.SemiBold,
                color = SkiptxtColor,
                modifier = Modifier.clickable { onSkipClick() }
            )
        }

        Spacer(Modifier.height(Ratio.h(0.05f)))

        /** ---------- Responsive Image Box ---------- */


        Image(
            painter = painterResource(R.drawable.onb_ic),
            contentDescription = null,
            modifier = Modifier.size(Ratio.w(0.7f)),
            alignment = Alignment.Center
        )


        Spacer(Modifier.height(Ratio.h(0.05f)))

        /** ---------- Title ---------- */
        Text(
            text = "Ready to Tele Porter?",
            color = Color(0xFFFAFAFA),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        /** ---------- Subtitle ---------- */
        Text(
            text = "Next, we'll guide you through connecting your Telegram bot. This is how your messages will be securely forwarded.",
            color = SkiptxtColor,
            style = TextStyle(
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp
            ),
            modifier = Modifier.fillMaxWidth()
        )
    }
}
