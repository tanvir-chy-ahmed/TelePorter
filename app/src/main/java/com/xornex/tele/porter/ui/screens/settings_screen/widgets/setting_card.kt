package com.xornex.tele.porter.ui.screens.settings_screen.widgets


import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.NavigateNext
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.ui.theme.CardColor

@Composable
fun SettingCard(
    title: String,
    subtitle: String? = null,
    color: Color,
    cardColor: Color = CardColor,
    leading: Int,
    leadingIcon: ImageVector = Icons.Default.Sync,
    trailingbeforeTxt: String? = "",
    onClick: () -> Unit = {},
    useSwitch: Boolean = false,
    useledingIcon: Boolean = false,
    uncheckedTrackColor: Color = Color(0xFF9EA3A8),
) {
    var isChecked by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = cardColor),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Leading Icon Box
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(color)
            ) {
                if (useledingIcon) {
                    Icon(
                        imageVector = leadingIcon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(30.dp)
                    )
                } else {
                    Image(
                        painter = painterResource(leading),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
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
                    fontSize = 18.sp
                )

                // Show subtitle only when provided
                subtitle?.let {
                    Spacer(modifier = Modifier.height(3.dp))
                    Text(
                        text = it,
                        color = Color(0xFFd1d5db),
                        fontSize = 14.sp
                    )
                }
            }




            if (useSwitch) {
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
                        uncheckedTrackColor = uncheckedTrackColor,
                        checkedBorderColor = Color.Transparent,
                        uncheckedBorderColor = Color.Transparent
                    )
                )
            } else {

                // 👇 FIX: Show text ONLY if not null
                trailingbeforeTxt?.let { safeText ->
                    Text(
                        text = safeText,
                        color = Color(0xFFd1d5db),
                        fontSize = 14.sp
                    )

                    Spacer(Modifier.fillMaxWidth(0.02f))

                    Icon(
                        imageVector = Icons.Default.NavigateNext,
                        contentDescription = null,
                        tint = Color(0xFF4b5563)
                    )
                }
            }


        }

    }
}

