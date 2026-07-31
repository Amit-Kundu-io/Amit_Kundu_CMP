/**
 * Timeline.kt
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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.AboutSection.models.TimelineEntry
import com.amit_kundu_io.presentation.components.RevealOnAppear
import com.amit_kundu_io.theme.LocalIsDarkTheme
import com.amit_kundu_io.theme.brandGradient

@Composable
 fun Timeline() {
     val timelineEntries = listOf(
        TimelineEntry(
            period = "2025 — Present",
            title = "Android Developer (Intern)",
            description = "Building production-ready Android features with Kotlin, Jetpack Compose, Ktor and Clean Architecture in an MVVM/MVI setup."
        ),
        TimelineEntry(
            period = "2024",
            title = "Compose Multiplatform Projects",
            description = "Explored shared UI across Android, Desktop and Web using Kotlin Multiplatform and Compose Multiplatform."
        ),
        TimelineEntry(
            period = "2022 — 2025",
            title = "B.Tech, Computer Science",
            description = "Focused on data structures, software architecture and mobile application development."
        )
    )
    Column {
        timelineEntries.forEachIndexed { index, entry ->
            RevealOnAppear(delayMillis = 150 + index * 120) { m ->
                TimelineRow(
                    entry = entry,
                    isLast = index == timelineEntries.lastIndex,
                    modifier = m
                )
            }
        }
    }
}


@Composable
private fun TimelineRow(entry: TimelineEntry, isLast: Boolean, modifier: Modifier = Modifier) {

    Row(modifier = modifier.fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box(
                modifier = Modifier
                    .size(14.dp)
                    .clip(CircleShape)
                    .background(brandGradient())
            )
            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(84.dp)
                        .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.4f))
                )
            }
        }

        Spacer(Modifier.width(20.dp))

        Column(modifier = Modifier.padding(bottom = if (isLast) 0.dp else 28.dp)) {
            Text(
                text = entry.period,
                style = MaterialTheme.typography.labelLarge,
                color = MaterialTheme.colorScheme.secondary
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = entry.title,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(6.dp))
            Text(
                text = entry.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

