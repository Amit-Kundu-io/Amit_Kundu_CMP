/**
 * SectionHeading.kt
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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.theme.LocalSpacing


/** An eyebrow label + gradient headline pair used at the top of every section. */
@Composable
fun SectionHeading(
    eyebrow: String,
    title: String,
    modifier: Modifier = Modifier,
    align: TextAlign = TextAlign.Start
) {
    val headlineStyle = if (LocalSpacing.current.maxContentWidth > 900.dp) {
        MaterialTheme.typography.displaySmall
    } else {
        MaterialTheme.typography.headlineLarge
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = if (align == TextAlign.Center) Alignment.CenterHorizontally else Alignment.Start
    ) {
        Text(
            text = eyebrow.uppercase(),
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.secondary,
            textAlign = align
        )
        Spacer(Modifier.height(6.dp))
        GradientText(
            text = title,
            style = headlineStyle,
            textAlign = align
        )
    }
}
