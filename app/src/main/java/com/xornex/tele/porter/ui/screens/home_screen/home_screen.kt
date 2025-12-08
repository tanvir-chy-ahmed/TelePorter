package com.xornex.tele.porter.ui.screens.home_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xornex.tele.porter.R
import com.xornex.tele.porter.ui.screens.home_screen.widget.HomeScreenCard
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.util.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavController) {

    TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = rememberTopAppBarState()
    )

    var isExpanded by remember {
        mutableStateOf(false)
    }

    val actionList = listOf(
        "Settings",
        "Filters",
        "Source Code",
        "Changelog",
        "Developer Info",
        "Feedback"
    )

    val iconList = listOf(
        R.drawable.setting,
        R.drawable.filters_ic,
        R.drawable.notification_ic,
        R.drawable.on_ic,
        R.drawable.clock_ic,
        R.drawable.info,
        R.drawable.star_ic,
        R.drawable.unlock_ic
    )


    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    Scaffold(
        containerColor = Background,
        floatingActionButton = {

            FloatingActionButton(
                onClick = {},
                containerColor = Color(0xFF0a84ff),
                shape = RoundedCornerShape(50.dp)
            ) {
                Icon(Icons.Default.Refresh, contentDescription = null, tint = Color.White)
            }
        }, topBar = {


            TopAppBar(
                scrollBehavior = scrollBehavior,

                colors = TopAppBarDefaults.topAppBarColors(containerColor = Background), title = {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            "All Messages",
                            color = Color(0xFFFAFAFA),
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            fontFamily = FontFamily.SansSerif
                        )

                        Spacer(modifier = Modifier.weight(1f)) // pushes icons to the end

                        IconButton(onClick = { /* search action */ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color(0xFFc8d2de)
                            )
                        }

                        IconButton(onClick = {
                            isExpanded = true
                        }) {
                            Icon(
                                imageVector = Icons.Default.MoreVert,
                                contentDescription = "More",
                                tint = Color(0xFFc8d2de)
                            )

                            // Attach menu to THIS icon
                            DropdownMenu(
                                expanded = isExpanded,
                                onDismissRequest = {
                                    isExpanded = false
                                }
                            ) {
                                actionList.forEachIndexed { index, action ->
                                    DropdownMenuItem(
                                        onClick = {
                                            isExpanded = false
                                            when (index) {
                                                0 -> {
                                                    navController.navigate(Routes.settings_screen)
                                                }

                                                1 -> {
                                                    navController.navigate(Routes.filter_screen)
                                                }
                                            }
                                        },
                                        text = { Text(text = action) },
                                        leadingIcon = {
                                            Icon(
                                                painter = painterResource(id = iconList[index]),
                                                contentDescription = null,
                                                modifier = Modifier.size(20.dp),
                                            )
                                        }
                                    )
                                }
                            }
                        }


                    }


                })
        }) { innerpadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding)
                .padding(top = 10.dp)
        ) {
            item {
                HomeScreenCard(
                    title = "01745239821",
                    subtitle = "BD Bank: Your A/C balance inquiry was successful.",
                    isSentSucess = false,
                    time = "Today, 4:15 PM"
                )

                HomeScreenCard(
                    title = "04218300544",
                    subtitle = "GP: You have 1GB data left. Valid till 11:59 PM.",

                    time = "Yesterday, 9:15 AM"
                )

                HomeScreenCard(
                    title = "09666777222",
                    subtitle = "Nagad: Tk 350 received from +880171234567.",
                    isSentSucess = false,
                    time = "Today, 4:15 PM"
                )

                HomeScreenCard(
                    title = "01588734321",
                    subtitle = "Bkash: Payment of Tk 120 accepted for Food Delivery.",

                    time = "Today, 4:15 PM"
                )

                HomeScreenCard(
                    title = "01822300989",
                    subtitle = "DBBL: A/C debited Tk 540 for mobile recharge.",

                    time = "Today, 4:15 PM"
                )

                HomeScreenCard(
                    title = "04411000902",
                    subtitle = "Sundarban Courier: Your parcel has arrived.",
                    isSentSucess = false,
                    time = "Yesterday, 9:15 AM"
                )

                HomeScreenCard(
                    title = "01989223344",
                    subtitle = "Teletalk: Your 7-day combo pack is activated.",

                    time = "Today, 4:15 PM"
                )

                HomeScreenCard(
                    title = "09611001009",
                    subtitle = "City Bank: Transaction alert – Tk 2,500 spent at SHOPNO.",
                    time = "Today, 4:15 PM"
                )

                HomeScreenCard(
                    title = "01300888121",
                    subtitle = "Robi: You’ve used 80% of your internet pack.",
                    isSentSucess = false,
                    time = "Today, 4:15 PM"
                )

                HomeScreenCard(
                    title = "01700992291",
                    subtitle = "Pathao: Your rider is arriving in 2 minutes.",
                    isSentSucess = false,
                    time = "Yesterday, 9:15 AM"
                )

            }
        }


    }
}
