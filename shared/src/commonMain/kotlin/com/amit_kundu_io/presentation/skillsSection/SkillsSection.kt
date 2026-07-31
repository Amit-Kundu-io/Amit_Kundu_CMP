/**
 * SkillsSection.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 * Updated On  : 31/07/2026 — premium redesign pass
 *
 * Description :
 * Skills section: categorized skill cards (Languages, Android, Multiplatform
 * & Backend, Tools) each with an animated proficiency bar. Uses a responsive
 * [FlowRow] grid so cards reflow naturally from 1 column on mobile up to 4+
 * on desktop, with a hover scale-up on pointer-capable devices.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.skillsSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.components.RevealOnAppear
import com.amit_kundu_io.presentation.components.SectionContainer
import com.amit_kundu_io.presentation.components.SectionHeading
import com.amit_kundu_io.presentation.skillsSection.companeants.CategoryBlock
import com.amit_kundu_io.presentation.skillsSection.models.Skill
import com.amit_kundu_io.presentation.skillsSection.models.SkillCategory


private val skillCategories = listOf(
    SkillCategory(
        title = "Languages",
        skills = listOf(
            Skill("Kotlin", 0.92f, "https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"),
            Skill("Java", 0.6f, "https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white"),
        )
    ),
    SkillCategory(
        title = "Android",
        skills = listOf(
            Skill("Jetpack Compose", 0.9f, "https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=android&logoColor=white"),
            Skill("MVVM / MVI", 0.85f, "https://img.shields.io/badge/MVVM-FF4088?style=for-the-badge"),
            Skill("Room & Coroutines", 0.8f, "https://img.shields.io/badge/Coroutines-0095D5?style=for-the-badge&logo=kotlin&logoColor=white"),
            Skill("Material 3", 0.85f, "https://img.shields.io/badge/Material%20UI-0081CB?style=for-the-badge&logo=materialdesign&logoColor=white")
        )
    ),
    SkillCategory(
        title = "Multiplatform & Backend",
        skills = listOf(
            Skill("Compose Multiplatform", 0.8f, "https://img.shields.io/badge/Compose%20Multiplatform-000000?style=for-the-badge&logo=jetbrains&logoColor=white"),
            Skill("Ktor", 0.75f, "https://img.shields.io/badge/Ktor-0095D5?style=for-the-badge&logo=kotlin&logoColor=white"),
            Skill("REST APIs", 0.82f, "https://img.shields.io/badge/Retrofit-009688?style=for-the-badge"),
            Skill("Clean Architecture", 0.8f, "https://img.shields.io/badge/Clean%20Architecture-000000?style=for-the-badge")
        )
    ),
    SkillCategory(
        title = "Tools",
        skills = listOf(
            Skill("Git & GitHub", 0.88f, "https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white"),
            Skill("Android Studio", 0.9f, "https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white"),
            Skill("Firebase", 0.7f, "https://img.shields.io/badge/Firebase-FFCA28?style=for-the-badge&logo=firebase&logoColor=black"),
        )
    )
)

@Composable
fun SkillsSection(modifier: Modifier = Modifier) {
    SectionContainer(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        RevealOnAppear(delayMillis = 0) { m ->
            SectionHeading(
                eyebrow = "What I work with",
                title = "Skills & Expertise",
                modifier = m
            )
        }

        Spacer(Modifier.height(40.dp))

        Column(verticalArrangement = Arrangement.spacedBy(44.dp)) {
            skillCategories.forEachIndexed { catIndex, category ->
                RevealOnAppear(delayMillis = 100 + catIndex * 120) { m ->
                    CategoryBlock(category = category, modifier = m)
                }
            }
        }
    }
}




