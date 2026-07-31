package com.amit_kundu_io

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.AboutSection.AboutSection
import com.amit_kundu_io.presentation.HomeSection.HeroSection
import com.amit_kundu_io.presentation.HomeSection.HomeSection
import com.amit_kundu_io.presentation.navigation.PortfolioTopBar
import com.amit_kundu_io.presentation.skillsSection.SkillsSection
import com.amit_kundu_io.theme.LocalDeviceType
import com.amit_kundu_io.theme.LocalIsDarkTheme
import com.amit_kundu_io.theme.LocalSpacing
import com.amit_kundu_io.theme.PortfolioTheme
import com.amit_kundu_io.theme.deviceTypeFor
import com.amit_kundu_io.theme.spacingFor
import com.amit_kundu_io.utilitis.ex_funcation.smoothScrollToItem
import kotlinx.coroutines.launch

@Composable
@Preview
fun App() {

    PortfolioTheme {
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val deviceType = remember(maxWidth) { deviceTypeFor(maxWidth) }
            val spacing = remember(deviceType) { spacingFor(deviceType) }

            CompositionLocalProvider(
                LocalDeviceType provides deviceType,
                LocalSpacing provides spacing,
            ) {
                val listState = rememberLazyListState()
                val scope = rememberCoroutineScope()

                var headerHeightPx by remember { mutableIntStateOf(0) }

                // measured height of every item, keyed by lazy index
                // (0 = sticky header, 1 = Home, 2 = About, 3 = Skills)
                val itemHeights = remember { mutableStateMapOf<Int, Int>() }

                fun scrollToItem(index: Int) {
                    scope.launch {
                        listState.smoothScrollToItem(
                            index = index,
                            itemHeights = itemHeights,
                            headerOffsetPx = headerHeightPx,
                            durationMillis = 1200
                        )
                    }
                }

                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(
                        state = listState,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        stickyHeader {
                            PortfolioTopBar(
                                onHomeClick = { scrollToItem(1) },
                                onAboutClick = { scrollToItem(2) },
                                onSkillsClick = { scrollToItem(3) },
                                modifier = Modifier.onGloballyPositioned {
                                    headerHeightPx = it.size.height
                                    itemHeights[0] = it.size.height
                                }
                            )
                        }

                        item {
                            HeroSection(
                                modifier = Modifier.onGloballyPositioned {
                                    itemHeights[1] = it.size.height
                                }
                            )
                        }
                        item {
                            AboutSection(
                                modifier = Modifier.onGloballyPositioned {
                                    itemHeights[2] = it.size.height
                                }
                            )
                        }
                        item {
                            SkillsSection(
                                modifier = Modifier.onGloballyPositioned {
                                    itemHeights[3] = it.size.height
                                }
                            )
                        }
                    }

                    // scroll-to-top FAB, only shown once scrolled past the header
                    val showScrollTop by remember {
                        derivedStateOf {
                            listState.firstVisibleItemIndex > 0 ||
                                    listState.firstVisibleItemScrollOffset > 0
                        }
                    }

                    AnimatedVisibility(
                        visible = showScrollTop,
                        enter = fadeIn() + scaleIn(),
                        exit = fadeOut() + scaleOut(),
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(spacing.horizontal, bottom = 24.dp)
                    ) {
                        FloatingActionButton(
                            onClick = {
                                scope.launch {
                                    listState.smoothScrollToItem(
                                        index = 0,
                                        itemHeights = itemHeights,
                                        headerOffsetPx = 0,
                                        durationMillis = 1000
                                    )
                                }
                            }
                        ) {
                            Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Scroll to top")
                        }
                    }
                }
            }
        }
    }
}

