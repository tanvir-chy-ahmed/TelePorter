package com.xornex.tele.porter.ui.screens.smsblacklist_screen.widgets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun BottomSheet(modifier: Modifier = Modifier) {

    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()
    BottomSheetScaffold(
        sheetPeekHeight = 0.dp,
        scaffoldState = scaffoldState,
        sheetContent = {
            Box(
                modifier
                    .fillMaxWidth()
                    .height(300.dp), contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.collapse()
                    }

                }) {
                    Text(text = "Close")
                }
            }
        }) {
        Box(
            modifier
                .fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch {
                    scaffoldState.bottomSheetState.expand()
                }
            }) {
                Text(text = "Open Bottom Sheet")
            }
        }
    }
}