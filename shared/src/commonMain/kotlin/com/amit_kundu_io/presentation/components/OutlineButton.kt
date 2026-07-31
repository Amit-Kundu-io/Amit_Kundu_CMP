/**
 * OutlineButton.kt
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

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

/** Outlined secondary button that matches [GradientButton]'s sizing. */
@Composable
fun OutlineButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HoverScale(modifier = modifier, scaleTo = 1.035f) { isHovered, hoverMod ->
        val color = MaterialTheme.colorScheme.onSurface
        Box(
            modifier = hoverMod
                .clip(RoundedCornerShape(14.dp))
                .border(
                    BorderStroke(1.5.dp, color.copy(alpha = if (isHovered) 0.9f else 0.45f)),
                    RoundedCornerShape(14.dp)
                )
                .clickable(onClick = onClick)
                .padding(horizontal = 28.dp, vertical = 14.dp)
        ) {
            Text(text = text, color = color, style = MaterialTheme.typography.labelLarge)
        }
    }
}