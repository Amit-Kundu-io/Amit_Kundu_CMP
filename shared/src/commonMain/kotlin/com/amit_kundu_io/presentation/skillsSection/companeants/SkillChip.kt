/**
 * SkillChip.kt
 *
 * Author      : Amit Kundu
 * Updated On  : redesign pass
 *
 * Description :
 * Compact pill representing a single skill: a tier-colored dot, the skill
 * name, and a small tier label (Expert / Advanced / Intermediate / Familiar).
 * Replaces the old full-width numeric progress-bar card with something
 * denser and easier to scan as a group — a whole category now reads as one
 * glanceable cloud instead of a tall stack of bars.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.skillsSection.companeants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.components.HoverScale
import com.amit_kundu_io.presentation.skillsSection.models.Skill
import com.amit_kundu_io.presentation.skillsSection.models.SkillTier
import com.amit_kundu_io.presentation.skillsSection.models.tier
import com.amit_kundu_io.theme.LocalIsDarkTheme

/** Maps a [SkillTier] to a theme color used for its dot + label. */
@Composable
private fun tierColor(tier: SkillTier): Color = when (tier) {
    SkillTier.Expert -> MaterialTheme.colorScheme.secondary
    SkillTier.Advanced -> MaterialTheme.colorScheme.primary
    SkillTier.Intermediate -> MaterialTheme.colorScheme.tertiary
    SkillTier.Familiar -> MaterialTheme.colorScheme.onSurfaceVariant
}

@Composable
fun SkillChip(skill: Skill, modifier: Modifier = Modifier) {
    val isDark = LocalIsDarkTheme.current
    val color = tierColor(skill.tier)

    HoverScale(modifier = modifier, scaleTo = 1.045f) { isHovered, hoverMod ->
        val fill = if (isDark) {
            Color.White.copy(alpha = if (isHovered) 0.09f else 0.05f)
        } else {
            Color.White.copy(alpha = if (isHovered) 0.9f else 0.65f)
        }
        val borderColor = if (isHovered) {
            color.copy(alpha = 0.8f)
        } else {
            MaterialTheme.colorScheme.outline.copy(alpha = if (isDark) 0.35f else 0.7f)
        }

        Row(
            modifier = hoverMod
                .clip(RoundedCornerShape(50))
                .background(fill)
                .border(BorderStroke(1.dp, borderColor), RoundedCornerShape(50))
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(color)
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = skill.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.width(8.dp))
            Text(
                text = skill.tier.label,
                style = MaterialTheme.typography.labelSmall,
                color = color
            )
        }
    }
}
