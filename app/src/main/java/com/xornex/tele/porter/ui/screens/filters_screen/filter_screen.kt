package com.xornex.tele.porter.ui.screens.filters_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.xornex.tele.porter.ui.screens.filters_screen.widgets.FilterCard
import com.xornex.tele.porter.ui.screens.widgets.CustomButton
import com.xornex.tele.porter.ui.theme.Background
import com.xornex.tele.porter.ui.theme.BottomSheetColor
import com.xornex.tele.porter.ui.theme.SkiptxtColor
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterScreen(modifier: Modifier = Modifier, navController: NavController) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    var showSheet by remember { mutableStateOf(false) }

    var text by remember { mutableStateOf("") }


    // ----------- BOTTOM SHEET -----------
    if (showSheet) {
        ModalBottomSheet(
            containerColor = BottomSheetColor,
            onDismissRequest = { showSheet = false },
            sheetState = sheetState
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentAlignment = Alignment.Center
            ) {
                // Sheet Contents

                Column(
                    modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Add New Filter", style = TextStyle(
                            color = SkiptxtColor, fontWeight = FontWeight.Bold, fontSize = 18.sp
                        )
                    )
                    Spacer(Modifier.height(20.dp))

                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                    ) {
                        TextField(
                            value = text, onValueChange = { text = it }, placeholder = {
                                Text(
                                    "Add Keyword", style = TextStyle(color = Color.Gray)
                                )
                            }, singleLine = true,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Number, // numeric keyboard
                                imeAction = ImeAction.Done          // action button on keyboard
                            ),
                            keyboardActions = KeyboardActions(
                                onDone = {
                                    // handle done action, e.g., hide keyboard or submit
                                }
                            ),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                    Spacer(Modifier.height(20.dp))

                    CustomButton(btntxt = "Save Filter", onClick = {})


                }


            }
        }
    }

    // ------------- MAIN SCREEN -------------
    Scaffold(
        modifier = modifier.fillMaxSize(), containerColor = Background,

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    scope.launch {
                        showSheet = true
                        sheetState.show()
                    }
                }, containerColor = Color(0xFF0da6f2), shape = RoundedCornerShape(50.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
            }
        },

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
                    text = "SMS Filters",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                )
            })
        }) { innerPadding ->
        Spacer(Modifier.height(20.dp))


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            item {
                Text(
                    "Hide messages containing specific keywords", style = TextStyle(
                        color = SkiptxtColor,
                        fontWeight = FontWeight.Normal,
                        fontSize = 16.sp
                    )
                )
                Spacer(Modifier.height(20.dp))
            }



            items(3) {
                FilterCard(
                    title = "Promo Code", color = Color(0xFF334155), onClick = {})
                Spacer(Modifier.height(20.dp))
            }
        }
    }
}





