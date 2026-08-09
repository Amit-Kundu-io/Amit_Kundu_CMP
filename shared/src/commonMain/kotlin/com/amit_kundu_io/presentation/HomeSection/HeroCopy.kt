/**
 * HeroCopy.kt
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

import amitkundu.shared.generated.resources.Res
import amitkundu.shared.generated.resources.attherate_icon
import amitkundu.shared.generated.resources.github_icon
import amitkundu.shared.generated.resources.linkedin_app_icon
import amitkundu.shared.generated.resources.whatsapp_icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amit_kundu_io.presentation.components.GradientText
import com.amit_kundu_io.presentation.components.RevealOnAppear
import com.amit_kundu_io.presentation.components.SocialIconButton
import com.amit_kundu_io.theme.DeviceType
import com.amit_kundu_io.theme.LocalDeviceType
import com.amit_kundu_io.utilitis.StaticLinks.WHATSAPP_LINK
import kotlinx.browser.window

@Composable
 fun HeroCopy(textAlign: TextAlign, alignment: Alignment.Horizontal) {
    val deviceType = LocalDeviceType.current
    val nameStyle = when (deviceType) {
        DeviceType.Desktop -> MaterialTheme.typography.displayLarge
        DeviceType.Tablet -> MaterialTheme.typography.displayMedium
        DeviceType.Mobile -> MaterialTheme.typography.displaySmall
        else -> {MaterialTheme.typography.displayLarge}
    }

    Column(horizontalAlignment = alignment) {
        RevealOnAppear(delayMillis = 0) { m ->
            Text(
                "Hi, I'm",
                modifier = m,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 20.sp,
                textAlign = textAlign
            )
        }

        Spacer(Modifier.height(8.dp))

        RevealOnAppear(delayMillis = 100) { m ->
            GradientText(
                text = "Amit Kundu",
                style = nameStyle,
                modifier = m,
                textAlign = textAlign
            )
        }

        Spacer(Modifier.height(14.dp))

        RevealOnAppear(delayMillis = 200) { m ->
            Text(
                "Android Developer • Compose Multiplatform Developer",
                modifier = m,
                color = MaterialTheme.colorScheme.secondary,
                fontSize = 19.sp,
                textAlign = textAlign,
                style = MaterialTheme.typography.titleLarge
            )
        }

        Spacer(Modifier.height(20.dp))

        RevealOnAppear(delayMillis = 300) { m ->
            Text(
                text = "Android Developer with internship experience building production-ready apps using Kotlin, Jetpack Compose, Ktor, MVVM/MVI and Clean Architecture.\n\nPassionate about building beautiful, fast and scalable applications.",
                modifier = m.widthIn(max = 560.dp),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 26.sp,
                fontSize = 16.sp,
                textAlign = textAlign,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(Modifier.height(32.dp))

        RevealOnAppear(delayMillis = 400) { m ->
            FlowButtons(modifier = m, deviceType = deviceType)
        }

        Spacer(Modifier.height(28.dp))

        RevealOnAppear(delayMillis = 500) { m ->
            Row(modifier = m, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                SocialIconButton(
                    icon = Res.drawable.github_icon
                    , onClick = {
                    window.open(url = "https://github.com/Amit-Kundu-io", target = "_blank")
                })
                SocialIconButton(
                   "IN"
                    , onClick = {
                    window.open(url = "https://linkedin.com/in/amit-kundu-io", target = "_blank")
                })

                SocialIconButton(
                    icon = Res.drawable.attherate_icon,
                    onClick = {
                        window.open(
                            url = "mailto:amitkundu.developer@gmail.com",
                            target = "_self"
                        )
                    }
                )

                SocialIconButton(
                    icon = Res.drawable.whatsapp_icon,
                    onClick = {
                        window.open(
                            url = WHATSAPP_LINK,
                            target = "_blank"
                        )
                    }
                )

            }
        }
    }
}