/**
 * HeroSection.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 *
 * Description :
 * Part of the project codebase. This file contributes to the overall
 * functionality and follows standard coding practices and architecture.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.HomeSection

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.window

@Composable
fun HeroSection() {

    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        visible = true
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(720.dp)
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0F172A),
                        Color(0xFF111827),
                        Color(0xFF0D1117)
                    )
                )
            )
    ) {

        AnimatedVisibility(
            visible = visible,
            enter = fadeIn(
                tween(800)
            ) + slideInHorizontally(
                animationSpec = tween(
                    durationMillis = 800,
                    easing = FastOutSlowInEasing
                ),
                initialOffsetX = { -300 }
            )
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 72.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(
                    modifier = Modifier.weight(1f)
                ) {

                    Text(
                        "Hi, I'm",
                        color = Color.LightGray,
                        fontSize = 24.sp
                    )

                    Spacer(Modifier.height(8.dp))

                    Text(
                        "Amit Kundu",
                        color = Color.White,
                        fontSize = 58.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(Modifier.height(18.dp))

                    Text(
                        "Android Developer • Compose Multiplatform Developer",
                        color = Color(0xFF3DDC84),
                        fontSize = 22.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(Modifier.height(24.dp))

                    Text(
                        text =
                            "Android Developer with internship experience building production-ready apps using Kotlin, Jetpack Compose, Ktor, MVVM/MVI and Clean Architecture.\n\nPassionate about building beautiful, fast and scalable applications.",
                        color = Color(0xFFB3B3B3),
                        lineHeight = 28.sp,
                        fontSize = 18.sp
                    )

                    Spacer(Modifier.height(36.dp))

                    Row {

                        Button(
                            onClick = { }
                        ) {

                            Text("Download Resume")
                        }

                        Spacer(Modifier.width(16.dp))

                        OutlinedButton(
                            onClick = {
                                window.open(
                                    url = "https://github.com/Amit-Kundu-io",
                                    target = "_blank"
                                )
                            }
                        ) {
                            Text("GitHub")
                        }

                        Spacer(Modifier.width(16.dp))

                        OutlinedButton(
                            onClick = {
                                window.open(
                                    url = "https://linkedin.com/in/amit-kundu-io",
                                    target = "_blank"
                                )
                            }
                        ) {
                            Text("LinkedIn")
                        }

                    }

                }

                Spacer(Modifier.width(60.dp))

                AnimatedVisibility(
                    visible = visible,
                    enter = fadeIn(
                        tween(1000)
                    ) + slideInVertically(
                        tween(1000)
                    )
                ) {

                    Surface(
                        modifier = Modifier
                            .size(320.dp)
                            .clip(CircleShape),
                        color = Color(0xFF1E293B),
                        tonalElevation = 8.dp
                    ) {

                        Box(
                            contentAlignment = Alignment.Center
                        ) {

                            Text(
                                "Your\nPhoto",
                                textAlign = TextAlign.Center,
                                color = Color.White
                            )

                        }

                    }

                }

            }

        }

    }

}