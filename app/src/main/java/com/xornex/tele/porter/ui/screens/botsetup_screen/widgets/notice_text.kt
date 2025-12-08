package com.xornex.tele.porter.ui.screens.botsetup_screen.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xornex.tele.porter.ui.theme.CardColor
import com.xornex.tele.porter.ui.theme.SkiptxtColor

@Composable
fun AlertText(text: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(containerColor = CardColor),
    ) {
        Row(
            modifier = Modifier
                .padding(17.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Leading Icon Box


            Icon(
                imageVector = Icons.Outlined.Info,
                contentDescription = null,
                tint = SkiptxtColor,
                modifier = Modifier.size(25.dp)
            )



            Spacer(modifier = Modifier.width(15.dp))

            // Title + Subtitle Column
            Column(
                modifier = Modifier.weight(1f)
            ) {


                Text(
                    text = text,
                    color = SkiptxtColor,
                    fontSize = 14.sp
                )

            }


        }

    }
}