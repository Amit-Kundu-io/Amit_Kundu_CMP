/**
 * theme.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 * Updated On  : 31/07/2026 — premium redesign pass
 *
 * Description :
 * Material 3 theme setup: color schemes, type scale, corner-radius scale
 * and a couple of theme-aware helpers (brand gradient / glass tint) that
 * every section composable pulls from instead of hard-coding values.
 */

package com.amit_kundu_io.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val DarkColors = darkColorScheme(
    primary = BrandPrimaryDark,
    onPrimary = Color(0xFF120E33),
    secondary = BrandAccentDark,
    onSecondary = Color(0xFF00291F),
    tertiary = BrandTertiaryDark,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnBackground,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
    error = ErrorColorDark
)

private val LightColors = lightColorScheme(
    primary = BrandPrimaryLight,
    onPrimary = Color.White,
    secondary = BrandAccentLight,
    onSecondary = Color.White,
    tertiary = BrandTertiaryLight,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnBackground,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    error = ErrorColorLight
)

/**
 * Base Material 3 type scale. Individual sections combine this with
 * [Spacing] / [DeviceType] to pick the right size for the current
 * breakpoint rather than hard-coding sp values.
 */
val PortfolioTypography = Typography(
    displayLarge = TextStyle(fontWeight = FontWeight.ExtraBold, fontSize = 57.sp, lineHeight = 64.sp, letterSpacing = (-0.25).sp),
    displayMedium = TextStyle(fontWeight = FontWeight.Bold, fontSize = 45.sp, lineHeight = 52.sp),
    displaySmall = TextStyle(fontWeight = FontWeight.Bold, fontSize = 36.sp, lineHeight = 44.sp),
    headlineLarge = TextStyle(fontWeight = FontWeight.Bold, fontSize = 32.sp, lineHeight = 40.sp),
    headlineMedium = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 28.sp, lineHeight = 36.sp),
    headlineSmall = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 24.sp, lineHeight = 32.sp),
    titleLarge = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 22.sp, lineHeight = 28.sp),
    titleMedium = TextStyle(fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.15.sp),
    titleSmall = TextStyle(fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
    bodyLarge = TextStyle(fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 26.sp, letterSpacing = 0.15.sp),
    bodyMedium = TextStyle(fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 22.sp, letterSpacing = 0.25.sp),
    bodySmall = TextStyle(fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 18.sp, letterSpacing = 0.4.sp),
    labelLarge = TextStyle(fontWeight = FontWeight.SemiBold, fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.1.sp),
    labelMedium = TextStyle(fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp),
    labelSmall = TextStyle(fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 16.sp, letterSpacing = 0.5.sp)
)

/** Consistent rounded-corner scale used by cards, buttons and chips app-wide. */
val PortfolioShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

/** Exposes the current dark/light choice to any composable without prop-drilling. */
val LocalIsDarkTheme = staticCompositionLocalOf { true }

@Composable
fun PortfolioTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors =  DarkColors

    MaterialTheme(
        colorScheme = colors,
        typography = PortfolioTypography,
        shapes = PortfolioShapes,
        content = content
    )
}

/** Signature brand gradient — used for hero backgrounds, CTA buttons, accent text. */
@Composable
fun brandGradient(): Brush = Brush.linearGradient(
    listOf(GradientStartLight, GradientMidLight, GradientEndLight)
)

/** Soft glass fill for glassmorphism surfaces, theme-aware. */
@Composable
fun glassTint(darkTheme: Boolean): Color = if (darkTheme) DarkGlassTint else LightGlassTint
