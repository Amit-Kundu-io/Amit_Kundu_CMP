/**
 * CategoryBlock.kt
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
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import com.amit_kundu_io.presentation.skillsSection.models.Skill
import com.amit_kundu_io.presentation.skillsSection.models.SkillCategory
import com.amit_kundu_io.theme.LocalDeviceType
import com.amit_kundu_io.theme.brandGradient
import com.amit_kundu_io.theme.isCompact

@Composable
fun CategoryBlock(category: SkillCategory, modifier: Modifier = Modifier) {
    val deviceType = LocalDeviceType.current

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

        // fixed-column grid instead of FlowRow — keeps card widths
        // and row alignment consistent across screen sizes
        val columns = when {
            deviceType.isCompact -> 1
            else -> 2
        }
        SkillGrid(skills = category.skills, columns = columns)
    }
}

@Composable
private fun SkillGrid(skills: List<Skill>, columns: Int) {
    val rows = skills.chunked(columns)
    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
        rows.forEach { rowSkills ->
            Row(horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                rowSkills.forEach { skill ->
                    SkillCard(skill = skill, modifier = Modifier.weight(1f))
                }
                // pad out incomplete last row so cards don't stretch full width
                repeat(columns - rowSkills.size) {
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}