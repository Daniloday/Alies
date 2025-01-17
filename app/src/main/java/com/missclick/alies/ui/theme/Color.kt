package com.missclick.alies.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color



data class Colors (
    val primaryBackground : Color,
    val secondaryBackground : Color,
    val accent: Color,
    val primary: Color,
    val primaryShadow: Color,
    val secondaryBackgroundShadow : Color,
    val primaryBackgroundShadow : Color
)


val darkColorPalette = Colors(
    primaryBackground = Color(0xFF332941),
    secondaryBackground = Color(0xFF3B3486),
    accent = Color(0xFF864AF9),
    primary = Color(0xFFF8E55A),
    primaryShadow = Color(0x1AF8E55A),
    secondaryBackgroundShadow = Color(0x803B3486),
    primaryBackgroundShadow = Color(0xE6332941)


)


val LocalColorProvider = staticCompositionLocalOf<Colors> {
    error("No colors")
}

