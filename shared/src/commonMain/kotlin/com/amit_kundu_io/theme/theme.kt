/**
 * theme.kt
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

package com.amit_kundu_io.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val Colors = darkColorScheme(
    primary = Primary,
    background = Background,
    surface = Surface
)

@Composable
fun PortfolioTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = Colors,
        content = content
    )
}