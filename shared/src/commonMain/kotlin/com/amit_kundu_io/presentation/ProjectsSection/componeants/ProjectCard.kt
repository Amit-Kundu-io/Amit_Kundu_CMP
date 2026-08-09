/**
 * ProjectCard.kt
 *
 * Author      : Amit Kundu
 * Created On  : Projects section pass
 *
 * Description :
 * A single project card: title + status badge, description, tech-stack
 * tags, and one or two CTA buttons. The whole card is clickable and opens
 * [Project.primaryUrl] (e.g. tapping anywhere on "Stay Focus" opens its
 * Play Store listing), matching the explicit button doing the same thing.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.ProjectsSection.componeants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amit_kundu_io.presentation.components.GlassCard
import com.amit_kundu_io.presentation.components.GradientButton
import com.amit_kundu_io.presentation.components.GradientText
import com.amit_kundu_io.presentation.components.HoverScale
import com.amit_kundu_io.presentation.components.OutlineButton
import com.amit_kundu_io.presentation.ProjectsSection.models.Project
import com.amit_kundu_io.theme.LocalIsDarkTheme
import kotlinx.browser.window

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCard(project: Project, modifier: Modifier = Modifier) {
    HoverScale(modifier = modifier, scaleTo = 1.015f) { _, hoverMod ->
        GlassCard(
            modifier = hoverMod
                .fillMaxWidth()
                .clickable { window.open(url = project.primaryUrl, target = "_blank") },
            padding = 24.dp
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                GradientText(
                    text = project.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(Modifier.weight(1f))
                StatusBadge(text = project.badge, isLive = project.isLive)
            }

            Spacer(Modifier.height(12.dp))

            Text(
                text = project.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 22.sp
            )

            Spacer(Modifier.height(16.dp))

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                project.tech.forEach { TechTag(it) }
            }

            Spacer(Modifier.height(20.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                GradientButton(
                    text = project.primaryLabel,
                    onClick = { window.open(url = project.primaryUrl, target = "_blank") }
                )
                if (project.secondaryLabel != null && project.secondaryUrl != null) {
                    OutlineButton(
                        text = project.secondaryLabel,
                        onClick = { window.open(url = project.secondaryUrl, target = "_blank") }
                    )
                }
            }
        }
    }
}

@Composable
private fun StatusBadge(text: String, isLive: Boolean) {
    val isDark = LocalIsDarkTheme.current
    val color = if (isLive) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(color.copy(alpha = if (isDark) 0.16f else 0.12f))
            .border(BorderStroke(1.dp, color.copy(alpha = 0.4f)), RoundedCornerShape(50))
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.SemiBold,
            color = color
        )
    }
}

@Composable
private fun TechTag(label: String) {
    val isDark = LocalIsDarkTheme.current
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = if (isDark) 0.6f else 1f))
            .padding(horizontal = 10.dp, vertical = 6.dp)
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}
