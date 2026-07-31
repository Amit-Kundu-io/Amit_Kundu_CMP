/**
 * ProfileAvatar.kt
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

package com.amit_kundu_io.presentation.HomeSection

import amitkundu.shared.generated.resources.Amit
import amitkundu.shared.generated.resources.Res
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.theme.LocalIsDarkTheme
import com.amit_kundu_io.theme.brandGradient
import org.jetbrains.compose.resources.painterResource


@Composable
 fun ProfileAvatar(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "avatarFloat")

    val density = LocalDensity.current

    val floatOffset by infiniteTransition.animateFloat(
        initialValue = with(density) { (-8).dp.toPx() },
        targetValue = with(density) { 8.dp.toPx() },
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 3500,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Float"
    )

    Box(
        modifier = modifier
            .graphicsLayer {
                translationY = floatOffset
            }
            .size(280.dp)
            .clip(CircleShape)
            .background(brandGradient()),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .size(266.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                .background(Color.White),
                contentAlignment = Alignment.Center

            ){
                Image(painter = painterResource(Res.drawable.Amit),null)

            }
        }
    }
}
