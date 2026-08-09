/**
 * SkillsSection.kt
 *
 * Author      : Amit Kundu
 * Created On  : 18/07/2026
 * Updated On  : redesign pass — chip cloud + filter tabs
 *
 * Description :
 * Skills section: categorized skill chips (Languages, Android, Multiplatform
 * & Backend, Tools), each a compact tier-colored pill instead of a numeric
 * progress bar. A row of filter pills above the categories lets visitors
 * narrow the view to a single category — a small but real interactive
 * improvement over a purely decorative list.
 *
 * Notes :
 * Ensure changes are consistent with project guidelines and maintain
 * code readability and quality.
 */

package com.amit_kundu_io.presentation.skillsSection

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.amit_kundu_io.presentation.components.RevealOnAppear
import com.amit_kundu_io.presentation.components.SectionContainer
import com.amit_kundu_io.presentation.components.SectionHeading
import com.amit_kundu_io.presentation.skillsSection.companeants.CategoryBlock
import com.amit_kundu_io.presentation.skillsSection.models.Skill
import com.amit_kundu_io.presentation.skillsSection.models.SkillCategory
import com.amit_kundu_io.theme.brandGradient


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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsSection(modifier: Modifier = Modifier) {
    // null = "All" selected
    var selectedCategory by remember { mutableStateOf<String?>(null) }

    val visibleCategories = if (selectedCategory == null) {
        skillCategories
    } else {
        skillCategories.filter { it.title == selectedCategory }
    }

    SectionContainer(modifier = modifier.background(MaterialTheme.colorScheme.background)) {
        RevealOnAppear(delayMillis = 0) { m ->
            SectionHeading(
                eyebrow = "What I work with",
                title = "Skills & Expertise",
                modifier = m
            )
        }

        Spacer(Modifier.height(10.dp))

        RevealOnAppear(delayMillis = 60) { m ->
            Text(
                text = "A quick look at the languages, frameworks and tools I reach for most — tap a category to filter.",
                modifier = m.widthIn(max = 560.dp),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        Spacer(Modifier.height(28.dp))

        RevealOnAppear(delayMillis = 100) { m ->
            FlowRow(
                modifier = m,
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                FilterPill(
                    label = "All",
                    isSelected = selectedCategory == null,
                    onClick = { selectedCategory = null }
                )
                skillCategories.forEach { category ->
                    FilterPill(
                        label = category.title,
                        isSelected = selectedCategory == category.title,
                        onClick = { selectedCategory = category.title }
                    )
                }
            }
        }

        Spacer(Modifier.height(36.dp))

        Column(verticalArrangement = Arrangement.spacedBy(44.dp)) {
            visibleCategories.forEachIndexed { catIndex, category ->
                RevealOnAppear(delayMillis = 100 + catIndex * 120) { m ->
                    CategoryBlock(category = category, modifier = m)
                }
            }
        }
    }
}

/** Selectable filter pill — gradient-filled when active, outlined otherwise. */
@Composable
private fun FilterPill(label: String, isSelected: Boolean, onClick: () -> Unit) {
    if (isSelected) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .background(brandGradient())
                .clickable(onClick = onClick)
                .padding(horizontal = 18.dp, vertical = 10.dp)
        ) {
            Text(
                text = label,
                color = Color.White,
                style = MaterialTheme.typography.labelLarge,
                fontWeight = FontWeight.SemiBold
            )
        }
    } else {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(50))
                .border(
                    BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.5f)),
                    RoundedCornerShape(50)
                )
                .clickable(onClick = onClick)
                .padding(horizontal = 18.dp, vertical = 10.dp)
        ) {
            Text(
                text = label,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}
