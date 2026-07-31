/**
 * GlassCard.kt
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
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.theme.LocalIsDarkTheme

/** Frosted / glassmorphism surface used by About & Skills cards. */
@Composable
fun GlassCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(24.dp),
    padding: Dp = 20.dp,
    content: @Composable ColumnScope.() -> Unit
) {
    val isDark = LocalIsDarkTheme.current
    val fill = if (isDark) Color.White.copy(alpha = 0.05f) else Color.White.copy(alpha = 0.65f)
    val border = MaterialTheme.colorScheme.outline.copy(alpha = if (isDark) 0.35f else 0.7f)

    Column(
        modifier = modifier
            .clip(shape)
            .background(fill)
            .border(BorderStroke(1.dp, border), shape)
            .padding(padding),
        content = content
    )
}