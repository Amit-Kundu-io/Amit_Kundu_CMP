/**
 * GradientButton.kt
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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.theme.LocalIsDarkTheme
import com.amit_kundu_io.theme.brandGradient

/** Primary call-to-action button filled with the brand gradient. */
@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HoverScale(modifier = modifier, scaleTo = 1.035f) { _, hoverMod ->
        val gradient = brandGradient()
        Box(
            modifier = hoverMod
                .clip(RoundedCornerShape(14.dp))
                .background(gradient)
                .clickable(onClick = onClick)
                .padding(horizontal = 28.dp, vertical = 14.dp)
        ) {
            Text(
                text = text,
                color = Color.White,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}
