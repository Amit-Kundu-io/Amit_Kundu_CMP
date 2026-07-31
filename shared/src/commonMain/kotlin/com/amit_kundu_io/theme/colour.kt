/**
 * colour.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 *
 * Description :
 * Part of the project codebase. This file contributes to the overall
 * functionality and follows standard coding practices and architecture.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.theme

import androidx.compose.ui.graphics.Color

/**
 * Brand colors — shared between light & dark themes.
 * Indigo/violet primary with a teal-green accent (nods to the original
 * Android-green identity) gives a premium, modern developer-portfolio feel.
 */
val BrandPrimaryLight = Color(0xFF5B4FE0)
val BrandPrimaryDark = Color(0xFF9C93FF)

val BrandAccentLight = Color(0xFF00A884)
val BrandAccentDark = Color(0xFF3DDC97)

val BrandTertiaryLight = Color(0xFFE0507A)
val BrandTertiaryDark = Color(0xFFFF7FA3)

/** Gradient stops used across Hero / CTA / accent surfaces. */
val GradientStartLight = Color(0xFF5B4FE0)
val GradientMidLight = Color(0xFF7B6EF6)
val GradientEndLight = Color(0xFF00A884)

val GradientStartDark = Color(0xFF6C5CE7)
val GradientMidDark = Color(0xFF9C93FF)
val GradientEndDark = Color(0xFF3DDC97)

// ---------------- Light theme neutrals ----------------
val LightBackground = Color(0xFFF7F8FC)
val LightSurface = Color(0xFFFFFFFF)
val LightSurfaceVariant = Color(0xFFEEF0F8)
val LightSurfaceElevated = Color(0xFFFFFFFF)
val LightOnBackground = Color(0xFF191A23)
val LightOnSurfaceVariant = Color(0xFF5B5F73)
val LightOutline = Color(0xFFDFE2EE)
val LightGlassTint = Color(0x0D191A23)

// ---------------- Dark theme neutrals ----------------
val DarkBackground = Color(0xFF0A0C12)
val DarkSurface = Color(0xFF141724)
val DarkSurfaceVariant = Color(0xFF1C2030)
val DarkSurfaceElevated = Color(0xFF1A1E2C)
val DarkOnBackground = Color(0xFFEEEFF7)
val DarkOnSurfaceVariant = Color(0xFFA1A6BC)
val DarkOutline = Color(0xFF2A2F42)
val DarkGlassTint = Color(0x14FFFFFF)

// ---------------- Semantic ----------------
val SuccessColor = Color(0xFF3DDC97)
val WarningColor = Color(0xFFFFB86B)
val ErrorColorLight = Color(0xFFDC3545)
val ErrorColorDark = Color(0xFFFF6B6B)

// Legacy aliases kept so any existing references keep compiling.
val Primary = BrandPrimaryDark
val Background = DarkBackground
val Surface = DarkSurface
val TextPrimary = DarkOnBackground
val TextSecondary = DarkOnSurfaceVariant
