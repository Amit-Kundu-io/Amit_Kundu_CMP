/**
 * FlowButtons.kt
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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.components.GradientButton
import com.amit_kundu_io.presentation.components.OutlineButton
import com.amit_kundu_io.theme.DeviceType
import com.amit_kundu_io.theme.isCompact
import com.amit_kundu_io.utilitis.StaticLinks.RESUME_LINK
import com.amit_kundu_io.utilitis.StaticLinks.WHATSAPP_LINK
import kotlinx.browser.window

@Composable
fun FlowButtons(modifier: Modifier, deviceType: DeviceType) {
    if (deviceType.isCompact) {
        Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(14.dp)) {
            GradientButton(
                text = "Download Resume",
                onClick = {
                    window.open(
                        url = RESUME_LINK,
                        target = "_blank"
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlineButton(
                text = "Contact Me",
                onClick = { window.open(url = WHATSAPP_LINK, target = "_blank") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    } else {
        Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)) {

            GradientButton(text = "Download Resume", onClick = {
                window.open(
                    url = RESUME_LINK,
                    target = "_blank"
                )
            }, modifier = Modifier)

            OutlineButton(
                text = "Contact Me",
                onClick = { window.open(url = WHATSAPP_LINK, target = "_blank") }
            )
        }
    }
}