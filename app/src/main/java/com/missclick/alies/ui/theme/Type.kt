package com.missclick.alies.ui.theme


import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp


data class Typography(
    val headerText : TextStyle,
)


val typography = Typography(
    headerText = TextStyle(
        fontFamily = FontFamily(Font(R.font.playbold)),
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold
    )
)

val LocalTypographyProvider = staticCompositionLocalOf<Typography> {
    error("No typography")
}