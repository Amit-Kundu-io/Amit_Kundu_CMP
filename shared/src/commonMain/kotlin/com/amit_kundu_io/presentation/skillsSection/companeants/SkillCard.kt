/**
 * SkillCard.kt
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

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amit_kundu_io.presentation.components.GlassCard
import com.amit_kundu_io.presentation.components.GradientText
import com.amit_kundu_io.presentation.components.HoverScale
import com.amit_kundu_io.presentation.skillsSection.models.Skill
import kotlin.math.roundToInt


@Composable
fun SkillCard(skill: Skill, modifier: Modifier = Modifier) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(skill.name) {
        visible = true
    }

    val progress by animateFloatAsState(
        targetValue = if (visible) skill.level else 0f,
        animationSpec = tween(
            durationMillis = 900,
            delayMillis = 150,
            easing = FastOutSlowInEasing
        ),
        label = "skillProgress"
    )

    val animatedPercent by animateIntAsState(
        targetValue = if (visible) (skill.level * 100).roundToInt() else 0,
        animationSpec = tween(
            durationMillis = 900,
            delayMillis = 150,
            easing = FastOutSlowInEasing
        ),
        label = "skillPercent"
    )

    HoverScale(modifier = modifier, scaleTo = 1.02f) { _, hoverMod ->
        GlassCard(modifier = hoverMod.fillMaxWidth(), padding = 18.dp) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                //     real shields.io badge image instead of the circle+glyph
                GradientText(
                    skill.name,
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontSize = 20.sp
                    )
                )

                Spacer(Modifier.weight(1f))
                Text(
                    text = "$animatedPercent%",
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.secondary
                )
            }

            Spacer(Modifier.height(14.dp))

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(4.dp)),
                color = MaterialTheme.colorScheme.secondary,
                trackColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.25f)
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = proficiencyLabel(skill.level),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

private fun proficiencyLabel(level: Float): String = when {
    level >= 0.85f -> "Expert"
    level >= 0.7f -> "Advanced"
    level >= 0.5f -> "Intermediate"
    else -> "Familiar"
}