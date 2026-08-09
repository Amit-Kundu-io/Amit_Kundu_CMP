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
        title = "Kevorin",
        badge = "OPEN SOURCE",
        description = "A modern Kotlin Multiplatform toolkit for reusable utilities, UI, and core " +
                "features shared across Android and iOS.",
        tech = listOf("Kotlin", "Kotlin Multiplatform"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.KEVORIN_REPO
    ),
    Project(
        title = "Amit Kundu — CMP",
        badge = "OPEN SOURCE",
        description = "The Compose Multiplatform source for this very portfolio site.",
        tech = listOf("Kotlin", "Compose Multiplatform"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.PORTFOLIO_CMP_REPO
    ),
    Project(
        title = "Smart Spend",
        badge = "OPEN SOURCE",
        description = "A Kotlin Android app for tracking spending and managing a personal budget.",
        tech = listOf("Kotlin", "Jetpack Compose"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.SMART_SPEND_REPO
    ),
    Project(
        title = "Skillforge",
        badge = "OPEN SOURCE",
        description = "A Kotlin Android project focused on skill-building and structured learning.",
        tech = listOf("Kotlin", "Jetpack Compose"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.SKILLFORGE_REPO
    ),
    Project(
        title = "App Limit",
        badge = "OPEN SOURCE",
        description = "An earlier Kotlin Android app for limiting daily usage of chosen apps — a " +
                "precursor to Stay Focus.",
        tech = listOf("Kotlin", "Jetpack Compose"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.APP_LIMIT_REPO
    ),
    Project(
        title = "Gamopedia",
        badge = "OPEN SOURCE",
        description = "A Compose Multiplatform app for browsing and discovering video game information.",
        tech = listOf("Kotlin", "Compose Multiplatform"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.GAMOPEDIA_CMP_REPO
    ),
    Project(
        title = "Melofy",
        badge = "OPEN SOURCE",
        description = "A Kotlin Android music app, paired with the Melofy-Server backend.",
        tech = listOf("Kotlin", "Jetpack Compose"),
        primaryLabel = "View Repository",
        primaryUrl = StaticLinks.MELOFY_REPO,
        secondaryLabel = "Server Repo",
        secondaryUrl = StaticLinks.MELOFY_SERVER_REPO
    ),
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
