/**
 * AboutSection.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 * Updated On  : 31/07/2026 — premium redesign pass
 *
 * Description :
 * About section: intro copy, an experience/education timeline and a row of
 * quick-stat glass cards. Fully responsive — two columns on desktop/tablet,
 * stacked on mobile — with a staggered scroll-reveal entrance.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.AboutSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.AboutSection.componeants.IntroAndStats
import com.amit_kundu_io.presentation.AboutSection.componeants.Timeline
import com.amit_kundu_io.presentation.components.RevealOnAppear
import com.amit_kundu_io.presentation.components.SectionContainer
import com.amit_kundu_io.presentation.components.SectionHeading
import com.amit_kundu_io.theme.LocalDeviceType
import com.amit_kundu_io.theme.isCompact


@Composable
fun AboutSection(modifier: Modifier) {
    val deviceType = LocalDeviceType.current

    SectionContainer(
        modifier = modifier.background(
            MaterialTheme.colorScheme.background
        )
    ) {
        RevealOnAppear(delayMillis = 0) { m ->
            SectionHeading(
                eyebrow = "Get to know me",
                title = "About Me",
                modifier = m
            )
        }

        Spacer(Modifier.height(36.dp))

        if (deviceType.isCompact) {
            Column {
                IntroAndStats()
                Spacer(Modifier.height(40.dp))
               // Timeline()
            }
        } else {
            Row(horizontalArrangement = Arrangement.spacedBy(56.dp)) {
                Column(modifier = Modifier.weight(1f)) {
                    IntroAndStats()
                }
//                Column(modifier = Modifier.weight(1f)) {
//                    Timeline()
//                }
            }
        }
    }
}








