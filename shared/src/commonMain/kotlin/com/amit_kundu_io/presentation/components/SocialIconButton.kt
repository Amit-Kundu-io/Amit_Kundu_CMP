/**
 * SocialIconButton.kt
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

package com.amit_kundu_io.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorProducer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amit_kundu_io.theme.GradientStartLight
import com.amit_kundu_io.theme.LocalIsDarkTheme
import com.amit_kundu_io.theme.brandGradient
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/** Small circular button for social links, rendered with a short glyph/initial. */
@Composable
fun SocialIconButton(
    glyph: String? = null,
    icon: DrawableResource? = null,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    HoverScale(modifier = modifier, scaleTo = 1.15f) { isHovered, hoverMod ->
        Box(
            modifier = hoverMod
                .size(46.dp)
                .clip(CircleShape)
                .background(
                    if (isHovered) brandGradient()
                    else Brush.linearGradient(
                        listOf(
                            MaterialTheme.colorScheme.surfaceVariant,
                            MaterialTheme.colorScheme.surfaceVariant
                        )
                    )
                )
                .border(
                    BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)),
                    CircleShape
                )
                .clickable(onClick = onClick),
            contentAlignment = Alignment.Center
        ) {
            if (icon != null) {
                Icon(
                    painter = painterResource(icon),
                    modifier = Modifier.size(35.dp),
                    tint = if (isHovered) Color.Black else GradientStartLight,
                    contentDescription = null)
            } else {
                glyph?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 30.sp
                        ),
                        color =  if (isHovered) Color.Black else GradientStartLight,
                    )
                }
            }
        }
    }
}

