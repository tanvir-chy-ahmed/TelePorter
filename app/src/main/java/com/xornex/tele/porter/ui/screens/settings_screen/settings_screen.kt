package com.xornex.tele.porter.ui.screens.settings_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xornex.tele.porter.R
import com.xornex.tele.porter.ui.screens.settings_screen.widgets.SettingCard
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.ui.theme.CardColor
import com.xornex.tele.porter.ui.theme.SkiptxtColor
import com.xornex.tele.porter.util.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        containerColor = Background,
        topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(Background), navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        Icons.Default.ArrowBackIosNew,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }, title = {
                Text(
                    text = "Settings",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            })
        }

    ) { innerpadding ->
        Divider(Modifier.padding(innerpadding), color = SkiptxtColor, thickness = 0.8.dp)
        LazyColumn(
            modifier
                .fillMaxSize()
                .padding(innerpadding)
                .padding(12.dp)
        ) {
            item {
                Spacer(modifier.height(10.dp))

                CustomText(text = "General")


                Spacer(modifier.height(10.dp))


                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(containerColor = CardColor),
                ) {
                    SettingCard(
                        title = "Manage Blacklist",
                        color = Color(0xFFef4444),
                        leading = R.drawable.shield_block_ic,

                        onClick = {
                            navController.navigate(Routes.blacklist_screen)
                        }

                    )

                    SettingCard(
                        title = "Notification Settings",
                        color = Color(0xFF3b82f6),
                        leading = R.drawable.notification_ic,


                        )
                }



                Spacer(modifier.height(22.dp))

                CustomText(text = "Forwarding")

                Spacer(modifier.height(10.dp))


                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(containerColor = CardColor),
                ) {
                    SettingCard(
                        title = "Enable Forwarding",
                        color = Color(0xFF22c55e),
                        leading = R.drawable.on_ic,
                        useSwitch = true

                    )

                    SettingCard(
                        title = "Forwarding Mode",
                        color = Color(0xFFf97316),
                        leading = R.drawable.clock_ic,
                        trailingbeforeTxt = "Instant",
                    )

                    SettingCard(
                        title = "Bot Setup",
                        color = Color(0xFF03A9F4),
                        leading = R.drawable.bot_setup,

                        onClick = {
                            navController.navigate(Routes.bot_setup_screen)
                        }
                    )
                }

                Spacer(modifier.height(22.dp))

                CustomText(text = "More")

                Spacer(modifier.height(10.dp))

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp),
                    colors = CardDefaults.cardColors(containerColor = CardColor),
                ) {
                    SettingCard(
                        title = "About Tele Porter",
                        color = Color(0xFF6b7280),
                        leading = R.drawable.info,

                        )


                    SettingCard(
                        title = "Rate App",
                        color = Color(0xFFeab308),
                        leading = R.drawable.star_ic,

                        )


                    SettingCard(
                        title = "Privacy Policy",
                        color = Color(0xFF6366f1),
                        leading = R.drawable.unlock_ic,

                        )
                }

                Column(
                    modifier
                        .fillMaxSize()
                        .padding(top = 60.dp, bottom = 60.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        "Tele Porter v1.0.0", style = TextStyle(
                            color = Color(0xFF4e5867),
                            fontSize = 16.sp

                        )
                    )
                }

            }


        }


    }


}


@Composable
fun CustomText(modifier: Modifier = Modifier, text: String) {
    Text(
        text = text, color = Color(0xFF626976), style = TextStyle(
            fontWeight = FontWeight.Bold, fontSize = 18.sp
        ), modifier = modifier.padding(start = 16.dp)
    )
}