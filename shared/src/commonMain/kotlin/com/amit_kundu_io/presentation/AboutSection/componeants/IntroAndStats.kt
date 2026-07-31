/**
 * IntroAndStats.kt
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

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.components.RevealOnAppear

@Composable
 fun IntroAndStats() {
    RevealOnAppear(delayMillis = 100) { m ->
        Text(
            text = "I'm an Android Developer who enjoys turning ideas into clean, fast and delightful apps. My work centres on Kotlin, Jetpack Compose and Compose Multiplatform, backed by Ktor for networking and a strong Clean Architecture / MVVM-MVI foundation.\n\nI care about maintainable code, thoughtful UI and shipping things that feel effortless to use.",
            modifier = m,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }

    Spacer(Modifier.height(28.dp))

    RevealOnAppear(delayMillis = 200) { m ->
        StatsGrid(modifier = m)
    }
}