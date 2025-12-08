package com.xornex.tele.porter.ui.screens.botsetup_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xornex.tele.porter.ui.screens.botsetup_screen.widgets.AlertText
import com.xornex.tele.porter.ui.screens.botsetup_screen.widgets.BotSetupCard
import com.xornex.tele.porter.ui.screens.botsetup_screen.widgets.BotSetupTextField
import com.xornex.tele.porter.ui.screens.botsetup_screen.widgets.CustomSetupCard
import com.xornex.tele.porter.ui.screens.widgets.CustomButton
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.util.Ratio


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SetupScreen(modifier: Modifier = Modifier, navController: NavController) {

    var scrollState = rememberScrollState()
    var tokentxt by remember { mutableStateOf("") }
    var chatid by remember { mutableStateOf("") }
    rememberCoroutineScope()

    // ------------- MAIN SCREEN -------------
    Scaffold(
        modifier = modifier.fillMaxSize(), containerColor = Background,

        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Background),
                title = {
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .padding(end = 48.dp)   // add space equal to nav icon width
                    ) {
                        Text(
                            text = "Bot Setup",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Default.ArrowBackIosNew,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(innerPadding)
                .padding(12.dp)
        ) {
            BotSetupCard(
                title = "Status: Not Connected",
                subtitle = "Enter your bot details to \nstart forwarding",
                onClick = {},
            )

            Spacer(Modifier.height(Ratio.h(0.01f)))
            BotSetupTextField(
                title = "Telegram Bot Token",
                value = tokentxt,
                onValueChange = { tokentxt = it },
                hint = "Enter Your Token Here"
            )

            Spacer(Modifier.height(Ratio.h(0.01f)))
            BotSetupTextField(
                title = "Telegram Chat Id",
                value = chatid,
                onValueChange = { chatid = it },
                hint = "Enter Your Chat ID"
            )

            Spacer(Modifier.height(Ratio.h(0.01f)))

            Box(
                modifier = Modifier.padding(start = 12.dp, end = 12.dp)
            ) {
                Column(
                    modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomSetupCard()





                    Spacer(
                        Modifier
                            .height(Ratio.h(0.03f))
                            .fillMaxWidth()
                    )

                    CustomButton(btntxt = "Save & Activate", onClick = {
                        //save and activate logic
                    })


                    Spacer(
                        Modifier
                            .height(Ratio.h(0.01f))
                            .fillMaxWidth()
                    )

                    TextButton(
                        onClick = {},

                        ) {
                        Text(
                            text = "Clear Saved Settings", style = TextStyle(
                                color = Color(0xFFff463b),
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                    Spacer(
                        Modifier
                            .height(Ratio.h(0.01f))
                            .fillMaxWidth()
                    )

                    AlertText(
                        text = "Our app only reads SMS to forward them to your Telegram bot. No data is stored on our servers."
                    )


                }

            }


        }
    }
}









