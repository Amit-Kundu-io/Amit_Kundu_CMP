/**
 * Responsive.kt
 *
 * Author      : Amit Kundu
 * Created On  : 31/07/2026
 *
 * Description :
 * Responsive breakpoint system for the portfolio. Provides a [DeviceType]
 * derived from available width plus a matching [Spacing] scale, so every
 * section can adapt padding, spacing and layout direction consistently
 * instead of hard-coding dp values per screen.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/** Breakpoints: Mobile < 600dp, Tablet 600–1023dp, Desktop/Web >= 1024dp. */
enum class DeviceType { Mobile, Tablet, Desktop, LargeDesktop }

/** Convenience checks used throughout the section composables. */
val DeviceType.isMobile get() = this == DeviceType.Mobile
val DeviceType.isCompact get() = this == DeviceType.Mobile || this == DeviceType.Tablet
val DeviceType.isLarge get() = this == DeviceType.LargeDesktop

data class Spacing(
    /** Outer left/right padding for section content. */
    val horizontal: Dp,
    /** Vertical padding between major sections. */
    val section: Dp,
    /** Padding inside cards / surfaces. */
    val card: Dp,
    /** Gap between related content items (e.g. list rows, chips). */
    val content: Dp,
    /** Max width the content column is constrained to on very wide screens. */
    val maxContentWidth: Dp
)

fun deviceTypeFor(width: Dp): DeviceType = when {
    width < 600.dp -> DeviceType.Mobile
    width < 1024.dp -> DeviceType.Tablet
    width < 1600.dp -> DeviceType.Desktop
    else -> DeviceType.LargeDesktop
}

fun spacingFor(deviceType: DeviceType): Spacing = when (deviceType) {
    DeviceType.Mobile -> Spacing(
        horizontal = 20.dp,
        section = 56.dp,
        card = 16.dp,
        content = 12.dp,
        maxContentWidth = 600.dp
    )
    DeviceType.Tablet -> Spacing(
        horizontal = 48.dp,
        section = 80.dp,
        card = 20.dp,
        content = 16.dp,
        maxContentWidth = 900.dp
    )
    DeviceType.Desktop -> Spacing(
        horizontal = 96.dp,
        section = 120.dp,
        card = 24.dp,
        content = 20.dp,
        maxContentWidth = 1200.dp
    )

    DeviceType.LargeDesktop -> Spacing(
        horizontal = 96.dp,
        section = 120.dp,
        card = 24.dp,
        content = 20.dp,
        maxContentWidth = 1200.dp
    )
}

/** Provided once at the App root from a `BoxWithConstraints`, consumed anywhere below it. */
val LocalDeviceType = staticCompositionLocalOf { DeviceType.Desktop }
val LocalSpacing = staticCompositionLocalOf { spacingFor(DeviceType.Desktop) }
