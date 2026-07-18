/**
 * HomeSection.kt
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

package com.amit_kundu_io.presentation.HomeSection


import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeSection(modifier: Modifier) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(700.dp),

        contentAlignment = Alignment.Center
    ) {

        HeroSection()

    }

}