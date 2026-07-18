/**
 * PortfolioTopBar.kt
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

package com.amit_kundu_io.presentation.navigation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun PortfolioTopBar(
    homeRequester: BringIntoViewRequester,
    aboutRequester: BringIntoViewRequester,
    skillsRequester: BringIntoViewRequester
) {
    val scope = rememberCoroutineScope()

    Row {

        TextButton(
            onClick = {
                scope.launch {
                    homeRequester.bringIntoView()
                }
            }
        ) {
            Text("Home")
        }

        TextButton(
            onClick = {
                scope.launch {
                    aboutRequester.bringIntoView()
                }
            }
        ) {
            Text("About")
        }

        TextButton(
            onClick = {
                scope.launch {
                    skillsRequester.bringIntoView()
                }
            }
        ) {
            Text("Skills")
        }
    }
}