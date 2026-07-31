/**
 * FloatingBackgroundBlobs.kt
 *
 * Author      : Amit Kundu
 * Created On  : 31/07/2026
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

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.theme.LocalIsDarkTheme

/** Slow, subtle floating blurred gradient shapes behind the hero content. */
@Composable
 fun FloatingBackgroundBlobs(modifier: Modifier = Modifier) {
    val isDark = LocalIsDarkTheme.current
    val infiniteTransition = rememberInfiniteTransition(label = "heroBlobs")

    val blobOneY by infiniteTransition.animateFloat(
        initialValue = -20f,
        targetValue = 20f,
        animationSpec = infiniteRepeatable(tween(6000, easing = LinearEasing), RepeatMode.Reverse),
        label = "blobOneY"
    )
    val blobTwoY by infiniteTransition.animateFloat(
        initialValue = 24f,
        targetValue = -24f,
        animationSpec = infiniteRepeatable(tween(7000, easing = LinearEasing), RepeatMode.Reverse),
        label = "blobTwoY"
    )

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .offset(x = (-120).dp, y = (-80 + blobOneY.toInt()).dp)
                .size(380.dp)
                .blur(120.dp)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = if (isDark) 0.35f else 0.22f),
                            Color.Transparent
                        )
                    )
                )
        )
        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 120.dp, y = (80 + blobTwoY.toInt()).dp)
                .size(420.dp)
                .blur(140.dp)
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        listOf(
                            MaterialTheme.colorScheme.secondary.copy(alpha = if (isDark) 0.3f else 0.2f),
                            Color.Transparent
                        )
                    )
                )
        )
    }
}
