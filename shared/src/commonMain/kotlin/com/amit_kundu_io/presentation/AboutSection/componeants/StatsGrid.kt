/**
 * StatsGrid.kt
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

package com.amit_kundu_io.presentation.AboutSection.componeants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.AboutSection.models.StatItem
import com.amit_kundu_io.presentation.components.GlassCard
import com.amit_kundu_io.presentation.components.GradientText

@OptIn(ExperimentalLayoutApi::class)
@Composable
 fun StatsGrid(modifier: Modifier = Modifier) {
     val statItems = listOf(
        StatItem("2+", "Years Learning"),
        StatItem("8+", "Projects Built"),
        StatItem("100%", "Clean Code Focus")
    )

    FlowRow(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        statItems.forEach { stat ->
            GlassCard(
                modifier = Modifier.widthIn(
                    min = 130.dp
                ), padding = 18.dp
            ) {
                GradientText(
                    text = stat.value,
                    style = MaterialTheme.typography.headlineMedium
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = stat.label,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}