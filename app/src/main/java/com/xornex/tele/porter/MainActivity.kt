package com.xornex.tele.porter

import android.Manifest
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import com.xornex.tele.porter.ui.navigation.SetUpNavGraph
import com.xornex.tele.porter.ui.theme.TelePorterTheme
import com.xornex.tele.porter.util.OnboardingUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val onboardingUtils by lazy { OnboardingUtils(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            val navController = rememberNavController()


            TelePorterTheme {
                // Launch permission after composition safely

                SetUpNavGraph(
                    navController = navController,
                    onboardingUtils = onboardingUtils
                )
            }
        }
    }
}
