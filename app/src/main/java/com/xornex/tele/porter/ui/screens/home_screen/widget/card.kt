package com.xornex.tele.porter.ui.screens.home_screen.widget


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.ErrorOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.ui.theme.CardColor
import com.xornex.tele.porter.ui.theme.FailedColor
import com.xornex.tele.porter.ui.theme.SentColor
import com.xornex.tele.porter.ui.theme.SkiptxtColor
import com.xornex.tele.porter.util.Ratio

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun HomeScreenCard(
    title: String,
    onClick:()->Unit,
    time: String,
    subtitle: String,
    isSentSucess: Boolean = true,
) {
    // Responsive font scaling
    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val titleTextSize = if (screenWidth < 360) 14.sp else 16.sp
    val subtitleTextSize = if (screenWidth < 360) 13.sp else 15.sp
    val timeTextSize = if (screenWidth < 360) 12.sp else 14.sp

    Card(
        onClick = onClick,
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = CardColor),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {

        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // ---------- TEXT PART ----------
            Column(
                modifier = Modifier.weight(1f)
            ) {

                // Top Row (From + Sent)
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "From $title",
                        color = Color(0xFFFAFAFA).copy(alpha = 0.95f),
                        fontWeight = FontWeight.Bold,
                        fontSize = titleTextSize,
                        fontFamily = FontFamily.SansSerif
                    )

                    Row(
                        horizontalArrangement = Arrangement.End
                    ) {

                        Icon(
                            imageVector = if (isSentSucess) Icons.Default.CheckCircleOutline else Icons.Default.ErrorOutline,
                            contentDescription = null,
                            tint = if (isSentSucess) SentColor else FailedColor,
                            modifier = Modifier.size(21.dp)
                        )
                        Spacer(modifier = Modifier.width(Ratio.w(0.01f)))
                        Text(
                            text = if (isSentSucess) "Sent" else "Failed",
                            color = if (isSentSucess) SentColor else FailedColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = titleTextSize,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                }

                Spacer(Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(0.8f)
                ) {
                    Text(
                        text = subtitle,
                        color = SkiptxtColor.copy(alpha = 0.9f),
                        fontSize = subtitleTextSize,
                        maxLines = 1,
                    )
                }

                Spacer(Modifier.height(8.dp))

                Text(
                    text = time,
                    color = SkiptxtColor,
                    fontSize = timeTextSize
                )
            }


            Spacer(Modifier.width(10.dp))


        }
    }
}
