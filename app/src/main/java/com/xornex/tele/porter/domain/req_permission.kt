package com.xornex.tele.porter.domain

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

@Composable
fun RequestPermission(
    onGranted:()-> Unit
) {

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestMultiplePermissions()
    ) {permissions->
        val allgranted = permissions.values.all { it }
        if(allgranted)
        {
            onGranted()
        }

    }

    LaunchedEffect(Unit) {
        launcher.launch(
            arrayOf(
                Manifest.permission.READ_SMS
            )
        )
    }
    
}