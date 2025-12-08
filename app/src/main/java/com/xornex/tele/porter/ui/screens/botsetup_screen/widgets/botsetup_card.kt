package com.xornex.tele.porter.ui.screens.botsetup_screen.widgets

import androidx.compose.foundation.border
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
import androidx.compose.material.icons.filled.CloudOff
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.ui.theme.CardColor
import com.xornex.tele.porter.ui.theme.SkiptxtColor


@Composable
fun BotSetupCard(
    title: String,
    subtitle: String? = null,          // optional
    onClick: () -> Unit = {},
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                elevation = 15.dp,
                shape = RoundedCornerShape(15.dp),
                spotColor = Color(0xFF009FFF)   // NEON COLOR
            )
            .border(
                width = 1.dp,
                color = Color(0xFF166086),       // same neon color
                shape = RoundedCornerShape(15.dp)
            ),
        colors = CardDefaults.cardColors(containerColor = CardColor),
        shape = RoundedCornerShape(15.dp),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Leading Icon Box

            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.CloudOff,
                    contentDescription = null,
                    tint = Color(0xFF0da6f2),
                    modifier = Modifier.size(80.dp)
                )
            }

            Spacer(modifier = Modifier.width(15.dp))

            // Title + Subtitle Column
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    color = Color(0xFFFAFAFA),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )

                Spacer(Modifier.height(5.dp))


                // Show subtitle only when provided
                subtitle?.let {
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = it,
                        color = SkiptxtColor,
                        fontSize = 17.sp
                    )
                }
            }


        }

    }
}