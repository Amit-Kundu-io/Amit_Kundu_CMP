/**
 * PortfolioTopBar.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 * Updated On  : 31/07/2026 — premium redesign pass
 *
 * Description :
 * Sticky top navigation bar. Shows a gradient brand mark, section links and
 * a light/dark theme toggle on desktop/tablet; collapses the links into a
 * dropdown menu behind a hamburger button on mobile so nothing ever wraps
 * or causes horizontal scrolling.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.components.GradientText
import com.amit_kundu_io.presentation.components.HoverScale
import com.amit_kundu_io.theme.LocalDeviceType
import com.amit_kundu_io.theme.LocalSpacing
import com.amit_kundu_io.theme.isCompact
import kotlinx.coroutines.launch

data class NavLink(val label: String, val onClick: () -> Unit)
@Composable
fun PortfolioTopBar(
    onHomeClick: () -> Unit,
    onAboutClick: () -> Unit,
    onSkillsClick: () -> Unit,
    onProjectsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val spacing = LocalSpacing.current
    val deviceType = LocalDeviceType.current

    val links = remember(onHomeClick, onAboutClick, onSkillsClick, onProjectsClick) {
        listOf(
            NavLink("Home", onHomeClick),
            NavLink("About", onAboutClick),
            NavLink("Skills", onSkillsClick),
            NavLink("Projects", onProjectsClick)
        )
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background.copy(alpha = 0.92f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = spacing.horizontal, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            GradientText(
                text = "Amit Kundu",
                style = MaterialTheme.typography.titleLarge
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                if (deviceType.isCompact) {
                    MobileNavMenu(
                        links = links,
                        onLinkSelected = { link -> link.onClick() }
                    )
                } else {
                    TextButton(onClick = onHomeClick) {
                        Text("Home", color = MaterialTheme.colorScheme.onSurface)
                    }
                    TextButton(onClick = onAboutClick) {
                        Text("About", color = MaterialTheme.colorScheme.onSurface)
                    }
                    TextButton(onClick = onSkillsClick) {
                        Text("Skills", color = MaterialTheme.colorScheme.onSurface)
                    }
                    TextButton(onClick = onProjectsClick) {
                        Text("Projects", color = MaterialTheme.colorScheme.onSurface)
                    }
                    Spacer(Modifier.width(8.dp))
                }
            }
        }

        HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f))
    }
}

@Composable
private fun MobileNavMenu(
    links: List<NavLink>,
    onLinkSelected: (NavLink) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box {
        TextButton(onClick = { expanded = true }) {
            Text("Menu", color = MaterialTheme.colorScheme.onSurface)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            links.forEach { link ->
                DropdownMenuItem(
                    text = { Text(link.label) },
                    onClick = {
                        expanded = false
                        onLinkSelected(link)
                    }
                )
            }
        }
    }
}

