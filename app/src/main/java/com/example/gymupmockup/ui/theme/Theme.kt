package com.example.gymupmockup.ui.theme


import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val GymUpDarkColorScheme = darkColorScheme(
    background = GymBlack,
    surface = GymSurface,
    primary = GymGold,
    onPrimary = GymBlack,
    onBackground = GymTextMain,
    onSurface = GymTextMain
)

@Composable
fun GymUpMockupTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = GymUpDarkColorScheme,
        content = content
    )
}