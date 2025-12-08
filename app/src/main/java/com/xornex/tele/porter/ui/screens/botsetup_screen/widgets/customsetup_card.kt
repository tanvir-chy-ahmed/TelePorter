package com.xornex.tele.porter.ui.screens.botsetup_screen.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.Sync
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.ui.theme.CardColor
import com.xornex.tele.porter.util.Ratio

@Composable
fun CustomSetupCard(modifier: Modifier = Modifier) {
    var isChecked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = CardColor),
    ) {
        Row(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth()
                .height(Ratio.h(0.04f)),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Leading Icon Box
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF283339))
            ) {

                Icon(
                    imageVector = Icons.Default.Sync,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(25.dp)
                )

            }

            Spacer(modifier = Modifier.width(15.dp))

            // Title + Subtitle Column
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Auto Forward SMS",
                    color = Color(0xFFFAFAFA),
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp
                )

            }





            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = it },
                thumbContent = {
                    Icon(
                        imageVector = Icons.Default.Circle,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = Color.White,
                    uncheckedThumbColor = Color.Gray,
                    checkedTrackColor = Color(0xFF22c55e),
                    uncheckedTrackColor = Color(0xFF283339),
                    checkedBorderColor = Color.Transparent,
                    uncheckedBorderColor = Color.Transparent
                )
            )


        }

    }
}