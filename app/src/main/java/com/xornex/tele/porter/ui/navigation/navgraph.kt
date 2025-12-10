package com.xornex.tele.porter.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.xornex.tele.porter.domain.repository.SmsRepository
import com.xornex.tele.porter.ui.screens.botsetup_screen.SetupScreen
import com.xornex.tele.porter.ui.screens.filters_screen.FilterScreen
import com.xornex.tele.porter.ui.screens.home_screen.HomeScreen
import com.xornex.tele.porter.ui.screens.onboarding.controller.OnboardingScreen
import com.xornex.tele.porter.ui.screens.settings_screen.SettingsScreen
import com.xornex.tele.porter.ui.screens.smsblacklist_screen.SmsBlackList
import com.xornex.tele.porter.util.OnboardingUtils
import com.xornex.tele.porter.util.Routes
import kotlinx.coroutines.launch

@Composable
fun SetUpNavGraph(navController: NavHostController, onboardingUtils: OnboardingUtils) {
    val scope = rememberCoroutineScope()
    NavHost(
        navController = navController,
        startDestination =
            if (onboardingUtils.isOnboadringCompleted())
                Routes.home_screen
            else
                Routes.onboarding_screen
    ) {

        composable(Routes.onboarding_screen) {
            OnboardingScreen(
                onFinished = {
                    scope.launch {
                        onboardingUtils.setOnBoardingCompleted()
                        navController.navigate(Routes.home_screen) {
                            popUpTo(Routes.onboarding_screen) { inclusive = true }
                        }
                    }

                },
                onSkiped = {
                    scope.launch {
                        onboardingUtils.setOnBoardingCompleted()
                        navController.navigate(Routes.home_screen) {
                            popUpTo(Routes.onboarding_screen) { inclusive = true }
                        }
                    }

                }

            )
        }

        // 2. Rest of navigation
        composable(Routes.home_screen) {
            HomeScreen(
                navController = navController, repository = SmsRepository(
                    LocalContext.current
                )
            )
        }
        composable(Routes.settings_screen) { SettingsScreen(navController = navController) }
        composable(Routes.blacklist_screen) { SmsBlackList(navController = navController) }
        composable(Routes.filter_screen) { FilterScreen(navController = navController) }
        composable(Routes.bot_setup_screen) { SetupScreen(navController = navController) }
    }
}
