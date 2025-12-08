package com.xornex.tele.porter.ui.screens.onboarding.controller

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.xornex.tele.porter.ui.screens.onboarding.OnboardingOne
import com.xornex.tele.porter.ui.screens.onboarding.OnboardingThree
import com.xornex.tele.porter.ui.screens.onboarding.OnboardingTwo
import com.xornex.tele.porter.ui.screens.onboarding.widgets.ButtonUi
import com.xornex.tele.porter.ui.theme.Background
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(onFinished: () -> Unit,onSkiped:()->Unit) {

    val scope = rememberCoroutineScope()
    val pages = listOf<@Composable () -> Unit>(
        { OnboardingOne(onSkipClick = onSkiped) },
        { OnboardingTwo() },
        { OnboardingThree() }
    )

    val pagestate = rememberPagerState(initialPage = 0) {
        pages.size
    }

    val buttonstate = remember {
        derivedStateOf {
            when (pagestate.currentPage) {
                0 -> listOf("", "Next")
                1 -> listOf("Back", "Next")
                2 -> listOf("Back", "Start Now")
                else -> listOf("", "")
            }
        }
    }




    Scaffold(
        containerColor = Background,
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (buttonstate.value[0].isNotEmpty()) {
                        ButtonUi(
                            title = buttonstate.value[0],
                            backgroundColor = Color.Transparent,
                            textColor = Color.Gray

                        ) {
                            scope.launch {
                                if (pagestate.currentPage > 0) {
                                    pagestate.animateScrollToPage(pagestate.currentPage - 1)

                                }
                            }

                        }
                    }

                }

                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.Center
                ) {
                    PageIndicator(pageSize = pages.size, currentPage = pagestate.currentPage)
                }


                Box(
                    modifier = Modifier.weight(1f),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    ButtonUi(buttonstate.value[1]) {
                        scope.launch {
                            if(pagestate.currentPage < pages.size -1)
                            {
                                pagestate.animateScrollToPage(pagestate.currentPage +1 )
                            }else{
                                onFinished()
                            }

                        }
                    }


                }


            }
        }
    ) { padding ->
        HorizontalPager(
            state = pagestate,
            modifier = Modifier.padding(padding)
        ) { index ->
            pages[index]()   // ← FIXED
        }

    }


}

