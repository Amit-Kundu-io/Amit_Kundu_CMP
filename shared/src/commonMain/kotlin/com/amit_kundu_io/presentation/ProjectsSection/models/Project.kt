/**
 * Project.kt
 *
 * Author      : Amit Kundu
 * Created On  : Projects section pass
 *
 * Description :
 * Data model for a single portfolio project card.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.ProjectsSection.models

data class Project(
    /** Project name, e.g. "Stay Focus". */
    val title: String,
    /** Short badge shown next to the title, e.g. "LIVE ON PLAY STORE" or "OPEN SOURCE". */
    val badge: String,
    /** One or two sentence summary shown on the card. */
    val description: String,
    /** Tech-stack tags rendered as small pills. */
    val tech: List<String>,
    /** Label for the primary CTA button, e.g. "View on Play Store". */
    val primaryLabel: String,
    /** URL opened by the primary CTA and by tapping the card. */
    val primaryUrl: String,
    /** Optional secondary CTA (e.g. a source-code link when the primary CTA is a store listing). */
    val secondaryLabel: String? = null,
    val secondaryUrl: String? = null,
    /** Drives the "live" accent styling on the badge. */
    val isLive: Boolean = false
)
