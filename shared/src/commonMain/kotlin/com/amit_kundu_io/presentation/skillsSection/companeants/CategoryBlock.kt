/**
 * CategoryBlock.kt
 *
 * Author      : Amit Kundu
 * Updated On  : redesign pass
 *
 * Description :
 * One skill category: an accent-bar title row followed by a wrapping cloud
 * of [SkillChip]s (a Compose FlowRow) instead of a fixed-column grid of
 * progress-bar cards. This reflows naturally at any width and keeps the
 * section short and scannable instead of tall and repetitive.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.skillsSection.companeants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.amit_kundu_io.presentation.skillsSection.models.SkillCategory
import com.amit_kundu_io.theme.brandGradient

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CategoryBlock(category: SkillCategory, modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxWidth()) {
        // accent bar + title, gives each category a visual anchor
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .width(4.dp)
                    .height(22.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(brandGradient())
            )
            Spacer(Modifier.width(10.dp))
            Text(
                text = category.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.weight(1f))
            Text(
                text = "${category.skills.size} skills",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(Modifier.height(18.dp))

        // wrapping chip cloud — reflows at any width, no manual column math
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            category.skills.forEach { skill ->
                SkillChip(skill = skill)
            }
        }
    }
}
