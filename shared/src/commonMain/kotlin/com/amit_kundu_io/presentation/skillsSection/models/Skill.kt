/**
 * Skill.kt
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

package com.amit_kundu_io.presentation.skillsSection.models

data class Skill(
 val name: String,
 val level: Float,
 val badgeUrl: String
)

/** Qualitative bucket for a skill's proficiency — shown instead of a raw percentage. */
enum class SkillTier(val label: String) {
    Expert("Expert"),
    Advanced("Advanced"),
    Intermediate("Intermediate"),
    Familiar("Familiar")
}

/** Buckets [Skill.level] (0f..1f) into a [SkillTier] for display. */
val Skill.tier: SkillTier
    get() = when {
        level >= 0.85f -> SkillTier.Expert
        level >= 0.7f -> SkillTier.Advanced
        level >= 0.5f -> SkillTier.Intermediate
        else -> SkillTier.Familiar
    }