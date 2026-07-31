/**
 * GradientText.kt
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

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.amit_kundu_io.theme.LocalIsDarkTheme
import com.amit_kundu_io.theme.brandGradient

/** Text rendered with the signature brand gradient brush. */
@Composable
fun GradientText(
    text: String,
    style: TextStyle,
    modifier: Modifier = Modifier,
    textAlign: TextAlign? = null
) {
    val gradient: Brush = brandGradient()
    Text(
        text = text,
        style = style.copy(brush = gradient),
        modifier = modifier,
        textAlign = textAlign
    )
}