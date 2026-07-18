/**
 * navigation.kt
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


data class NavItem(
    val title: String
)

val navItems = listOf(
    NavItem("Home"),
    NavItem("About"),
    NavItem("Skills"),
    NavItem("Projects"),
    NavItem("Contact")
)