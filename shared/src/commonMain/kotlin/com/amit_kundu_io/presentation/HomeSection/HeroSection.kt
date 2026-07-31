/**
 * HeroSection.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 * Updated On  : 31/07/2026 — premium redesign pass
 *
 * Description :
 * Hero / landing section. Fully responsive (stacked on mobile/tablet, side
 * by side on desktop/web), animated floating gradient blobs in the
 * background, gradient headline, staggered entrance animation and a
 * gently floating profile avatar.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.HomeSection

import amitkundu.shared.generated.resources.Amit
import amitkundu.shared.generated.resources.Res
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amit_kundu_io.presentation.components.GradientButton
import com.amit_kundu_io.presentation.components.GradientText
import com.amit_kundu_io.presentation.components.OutlineButton
import com.amit_kundu_io.presentation.components.RevealOnAppear
import com.amit_kundu_io.presentation.components.SocialIconButton
import com.amit_kundu_io.theme.DeviceType
import com.amit_kundu_io.theme.LocalDeviceType
import com.amit_kundu_io.theme.LocalIsDarkTheme
import com.amit_kundu_io.theme.LocalSpacing
import com.amit_kundu_io.theme.brandGradient
import com.amit_kundu_io.theme.isCompact
import kotlinx.browser.window
import org.jetbrains.compose.resources.painterResource

@Composable
fun HeroSection(modifier: Modifier = Modifier) {
    val spacing = LocalSpacing.current
    val deviceType = LocalDeviceType.current

    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
    ) {
        FloatingBackgroundBlobs(modifier = Modifier.fillMaxSize())

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = spacing.maxContentWidth + spacing.horizontal * 2)
                .padding(horizontal = spacing.horizontal, vertical = spacing.section)
        ) {
            if (deviceType.isCompact) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RevealOnAppear(delayMillis = 100) { m -> ProfileAvatar(modifier = m) }
                    Spacer(Modifier.height(32.dp))
                    HeroCopy(textAlign = TextAlign.Center, alignment = Alignment.CenterHorizontally)
                }
            } else {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        HeroCopy(textAlign = TextAlign.Start, alignment = Alignment.Start)
                    }
                    Spacer(Modifier.width(64.dp))
                    RevealOnAppear(delayMillis = 150) { m -> ProfileAvatar(modifier = m) }
                }
            }
        }
    }
}



