package com.xornex.tele.porter.ui.screens.home_screen

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import areSmsPermissionsGranted
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.xornex.tele.porter.R
import com.xornex.tele.porter.domain.model.SmsData
import com.xornex.tele.porter.domain.repository.SmsRepository
import com.xornex.tele.porter.ui.screens.home_screen.widget.HomeScreenCard
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.util.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, repository: SmsRepository) {


    var isExpanded by remember { mutableStateOf(false) }
    var permissionGranted by remember { mutableStateOf(false) }

    val context = LocalContext.current

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    val smslist = remember { mutableStateListOf<SmsData>() }

    val scope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }
    val swipestate = rememberSwipeRefreshState(isRefreshing = refreshing)


    // Permission launcher
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        permissionGranted = permissions[Manifest.permission.READ_SMS] == true &&
                permissions[Manifest.permission.RECEIVE_SMS] == true

        Toast.makeText(
            context,
            if (permissionGranted) "SMS Permissions Granted" else "SMS Permissions Denied",
            Toast.LENGTH_SHORT
        ).show()
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
        R.drawable.info
    )


    fun refreshSMS() {
        if (permissionGranted) {
            scope.launch {
                refreshing = true
                smslist.clear()
                smslist.addAll(repository.getAllSms())
                delay(3000)
                refreshing = false
            }

        }
    }


    // Check initial permission
    LaunchedEffect(Unit) {
        permissionGranted = areSmsPermissionsGranted(context)
    }

    // Load SMS only if permission granted
    LaunchedEffect(permissionGranted) {
        if (permissionGranted) {
            smslist.clear()
            smslist.addAll(repository.getAllSms())
        }
    }


    Scaffold(
        containerColor = Background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                    refreshSMS()


                },
                containerColor = Color(0xFF0a84ff),
                shape = RoundedCornerShape(50.dp)
            ) {
                if (refreshing) {
                    CircularProgressIndicator(
                        color = Color.White,
                        strokeWidth = 2.dp,
                        modifier = Modifier.size(24.dp)
                    )
                } else {
                    Icon(Icons.Default.Refresh, contentDescription = null, tint = Color.White)
                }

            }
        },
        topBar = {
            TopAppBar(
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Background),
                title = {
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

                        Spacer(modifier = Modifier.weight(1f))

                        IconButton(onClick = { /* search action */ }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search",
                                tint = Color(0xFFc8d2de)
                            )
                        }

                        Box {
                            IconButton(onClick = { isExpanded = true }) {
                                Icon(
                                    imageVector = Icons.Default.MoreVert,
                                    contentDescription = "More",
                                    tint = Color(0xFFc8d2de)
                                )
                            }

                            DropdownMenu(
                                expanded = isExpanded,
                                onDismissRequest = { isExpanded = false },
                            ) {
                                actionList.forEachIndexed { index, action ->
                                    DropdownMenuItem(
                                        onClick = {
                                            isExpanded = false
                                            when (index) {
                                                0 -> navController.navigate(Routes.settings_screen)
                                                1 -> navController.navigate(Routes.filter_screen)
                                            }
                                        },
                                        text = { Text(text = action) },
                                        leadingIcon = {
                                            if (index < iconList.size) {
                                                Icon(
                                                    painter = painterResource(id = iconList[index]),
                                                    contentDescription = null,
                                                    modifier = Modifier.size(20.dp),
                                                )
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    ) { innerPadding ->

        if (permissionGranted) {
            SwipeRefresh(
                state = swipestate,
                onRefresh = { refreshSMS() },
                refreshTriggerDistance = 200.dp
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .padding(top = 10.dp),
                ) {
                    items(smslist) { sms ->
                        HomeScreenCard(
                            title = sms.sender,
                            subtitle = sms.body,
                            isSentSucess = false,
                            time = sms.date,
                            onClick = {
                                navController.navigate(Routes.details_screen)
                            }
                        )
                    }
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Background),
                contentAlignment = Alignment.Center
            ) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(Background),
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "Permission Needed",
                            fontSize = 20.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "This app needs access to your SMS to function properly.",
                            fontSize = 16.sp,
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = {
                                permissionLauncher.launch(
                                    arrayOf(
                                        Manifest.permission.READ_SMS,
                                        Manifest.permission.RECEIVE_SMS,
                                        Manifest.permission.POST_NOTIFICATIONS
                                    )
                                )
                            }
                        ) {
                            Text(text = "Grant Permission")
                        }
                    }
                }
            }
        }
    }
}

