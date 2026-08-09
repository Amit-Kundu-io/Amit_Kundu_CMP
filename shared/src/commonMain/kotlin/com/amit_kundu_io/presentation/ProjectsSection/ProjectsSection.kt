/**
 * ProjectsSection.kt
 *
 * Author      : Amit Kundu
 * Created On  : Projects section pass
 *
 * Description :
 * Projects section: a stack of [ProjectCard]s pulled from the resume /
 * GitHub. "Stay Focus" is pinned first since it's the live, shipped
 * product — tapping its card (or the primary button) opens its Play Store
 * listing directly. The other projects link out to their GitHub repos.
 * Closed with a "View all projects on GitHub" link to the profile.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.ProjectsSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.components.OutlineButton
import com.amit_kundu_io.presentation.components.RevealOnAppear
import com.amit_kundu_io.presentation.components.SectionContainer
import com.amit_kundu_io.presentation.components.SectionHeading
import com.amit_kundu_io.presentation.ProjectsSection.componeants.ProjectCard
import com.amit_kundu_io.presentation.ProjectsSection.models.Project
import com.amit_kundu_io.utilitis.StaticLinks
import kotlinx.browser.window

private val projects = listOf(
    // Pinned first — live, shipped product. Card + primary button both
    // open the Play Store listing.
    Project(
        title = "Stay Focus",
        badge = "LIVE ON PLAY STORE",
        description = "A screen-time reducer that blocks YouTube Shorts, Instagram Reels and other " +
            "short-form content via Android's Accessibility Service, with daily time limits and " +
            "app-restriction features to help cut down on doom-scrolling.",
        tech = listOf("Kotlin", "Jetpack Compose", "Material 3", "DataStore", "Accessibility Service"),
        primaryLabel = "View on Play Store",
        primaryUrl = StaticLinks.STAY_FOCUS_PLAY_STORE,
        isLive = true
    ),
    Project(
        title = "DevRank",
        badge = "OPEN SOURCE",
        description = "A Compose Multiplatform app for exploring top-starred GitHub repositories and " +
            "developer profiles, built with MVI so app state stays predictable and easy to debug.",
        tech = listOf("Kotlin", "Compose Multiplatform", "Ktor", "MVI", "Clean Architecture"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.DEVRANK_REPO
    ),
    Project(
        title = "Employee Location Display App",
        badge = "OPEN SOURCE",
        description = "An Android app that shows employee locations on a live map, using the Google " +
            "Maps SDK for markers and REST APIs for location data.",
        tech = listOf("Kotlin", "Jetpack Compose", "Google Maps SDK", "REST API"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.EMPLOYEE_LOCATION_REPO
    )
)

@Composable
fun ProjectsSection(modifier: Modifier = Modifier) {
    SectionContainer(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        RevealOnAppear(delayMillis = 0) { m ->
            SectionHeading(
                eyebrow = "What I've built",
                title = "Projects",
                modifier = m
            )
        }

        Spacer(Modifier.height(36.dp))

        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
            projects.forEachIndexed { index, project ->
                RevealOnAppear(delayMillis = index * 120) { m ->
                    ProjectCard(project = project, modifier = m)
                }
            }
        }

        Spacer(Modifier.height(28.dp))

        RevealOnAppear(delayMillis = projects.size * 120) { m ->
            OutlineButton(
                text = "View all projects on GitHub",
                onClick = { window.open(url = StaticLinks.GITHUB_PROFILE, target = "_blank") },
                modifier = m
            )
        }
    }
}
