/**
 * RevealOnAppear.kt
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

package com.amit_kundu_io.presentation.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import kotlinx.coroutines.delay

/**
 * Fades + slides content up the first time it enters composition. Because
 * [androidx.compose.foundation.lazy.LazyColumn] only composes items close to
 * the viewport, wrapping section content in this gives a natural
 * "reveal on scroll" effect without wiring up manual viewport math.
 */
@Composable
fun RevealOnAppear(
    modifier: Modifier = Modifier,
    delayMillis: Int = 0,
    durationMillis: Int = 650,
    content: @Composable (Modifier) -> Unit
) {
    var started by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(delayMillis.toLong())
        started = true
    }

    val progress by animateFloatAsState(
        targetValue = if (started) 1f else 0f,
        animationSpec = tween(durationMillis = durationMillis, easing = FastOutSlowInEasing),
        label = "revealOnAppear"
    )

    content(
        modifier.graphicsLayer {
            alpha = progress
            translationY = (1f - progress) * 32f
        }
    )
}