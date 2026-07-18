package com.amit_kundu_io

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import com.amit_kundu_io.presentation.components.AboutSection
import com.amit_kundu_io.presentation.HomeSection.HomeSection
import com.amit_kundu_io.presentation.components.SkillsSection
import com.amit_kundu_io.presentation.navigation.PortfolioTopBar
import com.amit_kundu_io.theme.PortfolioTheme

@Composable
@Preview
fun App() {
    PortfolioTheme {
        val homeRequester = remember { BringIntoViewRequester() }
        val aboutRequester = remember { BringIntoViewRequester() }
        val skillsRequester = remember { BringIntoViewRequester() }

        val scrollState = rememberScrollState()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            stickyHeader {
                PortfolioTopBar(
                    homeRequester = homeRequester,
                    aboutRequester = aboutRequester,
                    skillsRequester = skillsRequester
                )

            }
            item {
                HomeSection(
                    modifier = Modifier.bringIntoViewRequester(homeRequester)
                )
            }

            item {
                AboutSection(
                    modifier = Modifier.bringIntoViewRequester(aboutRequester)
                )
            }


            item {
                SkillsSection(
                    modifier = Modifier.bringIntoViewRequester(skillsRequester)
                )
            }


        }

    }

}