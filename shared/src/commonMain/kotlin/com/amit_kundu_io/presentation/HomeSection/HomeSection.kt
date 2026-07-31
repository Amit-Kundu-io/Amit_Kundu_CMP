/**
 * HomeSection.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 * Updated On  : 31/07/2026 — premium redesign pass
 *
 * Description :
 * Thin wrapper around [HeroSection]. Height is no longer hard-coded — the
 * hero manages its own responsive sizing based on content and device type,
 * so this simply forwards the scroll-anchor modifier from [com.amit_kundu_io.App].
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.HomeSection

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomeSection(modifier: Modifier) {
    HeroSection(modifier = modifier.fillMaxWidth())
}
