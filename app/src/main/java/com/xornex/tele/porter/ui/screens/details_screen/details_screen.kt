package com.xornex.tele.porter.ui.screens.details_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.util.Ratio
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController) {
    var message by remember { mutableStateOf("") }
    Scaffold(
        containerColor = Background,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(Background),
                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                actions = {

                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.MoreVert,
                            contentDescription = null,
                            tint = Color(0xFFaac7ff),
                        )
                    }

                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            Icons.Default.ArrowBackIosNew,
                            contentDescription = null,
                            tint = Color(0xFFaac7ff),
                        )
                    }
                    Spacer(modifier = Modifier.width(Ratio.w(0.1f)))

                },
                title = {
                    Row(

                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {

                            },
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Default.AccountCircle,
                            contentDescription = null,
                            Modifier.size(40.dp),
                            tint = Color(0xFFaac7ff),
                        )
                        Spacer(modifier = Modifier.width(Ratio.w(0.03f)))
                        Text(
                            text = "Jim Testing", style = TextStyle(
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold, color = Color(0xFFaac7ff)
                            )
                        )
                    }


                }

            )
        }

    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            MessageList()
            Spacer(modifier = Modifier.weight(1f))
            MessageInput()
        }

    }
}

@Composable
fun MessageList() {
    val message = "ff"
    if (message.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No Message are there",
                    style = MaterialTheme.typography.headlineSmall,
                    color = Color.LightGray
                )
            }
        }

    } else {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(20.dp),
            horizontalArrangement = Arrangement.Start
        ) {


            LazyColumn(modifier = Modifier.fillMaxHeight(0.9f),) {
                items(10) { item ->
                    Bubble("Dear C/H Please Collect your cheque book from your nearest branch")
                }

            }


        }
    }

}


@Composable
fun MessageInput() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,

        ) {
        Text(
            text = "Can't reply to this short code.",
            style = MaterialTheme.typography.bodyMedium,
            color = Color(0xFFaac7ff)
        )
    }
}


@Composable
fun Bubble(text: String) {
    Box(
        modifier = Modifier
            .shadow(4.dp, RoundedCornerShape(16.dp))
            .background(
                color = Color.White,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(14.dp)
    ) {
        Text(text, style = MaterialTheme.typography.bodyLarge)
    }

    Spacer(modifier = Modifier.height(30.dp))


}
