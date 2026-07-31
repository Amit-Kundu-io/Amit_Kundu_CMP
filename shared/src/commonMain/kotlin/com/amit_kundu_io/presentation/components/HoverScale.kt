/**
 * HoverScale.kt
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

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer


/** Adds a subtle pointer-hover scale-up — desktop/web only has real "hover". */
@Composable
fun HoverScale(
    modifier: Modifier = Modifier,
    scaleTo: Float = 1.04f,
    content: @Composable (isHovered: Boolean, Modifier) -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val scale by animateFloatAsState(
        targetValue = if (isHovered) scaleTo else 1f,
        animationSpec = tween(200),
        label = "hoverScale"
    )

    content(
        isHovered,
        modifier
            .hoverable(interactionSource)
            .graphicsLayer { scaleX = scale; scaleY = scale }
    )
}
