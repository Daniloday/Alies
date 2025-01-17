package com.missclick.alies.ui.theme


import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.missclick.alies.R


data class Typography(
    val headerTextBold: TextStyle,
    val headerTextThin: TextStyle,
    val nextButtonText: TextStyle,
    val teamCardText: TextStyle,
    val roundCardText: TextStyle,
    val roundWordsText: TextStyle,
    val skipWordText: TextStyle,
    val guessedWordText: TextStyle,
    val smallShowedWordText : TextStyle
)


val typography = Typography(
    headerTextBold = TextStyle(
        fontFamily = FontFamily(Font(R.font.playbold)),
        fontSize = 36.sp,
        fontWeight = FontWeight.Bold
    ),
    headerTextThin = TextStyle(
        fontFamily = FontFamily(Font(R.font.playregular)),
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal
    ),
    nextButtonText = TextStyle(
        fontFamily = FontFamily(Font(R.font.playbold)),
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold
    ),
    teamCardText = TextStyle(
        fontFamily = FontFamily(Font(R.font.playregular)),
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal
    ),
    roundCardText = TextStyle(
        fontFamily = FontFamily(Font(R.font.playbold)),
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold
    ),
    roundWordsText = TextStyle(
        fontFamily = FontFamily(Font(R.font.playregular)),
        fontSize = 32.sp,
        fontWeight = FontWeight.Normal
    ),
    skipWordText = TextStyle(
        fontFamily = FontFamily(Font(R.font.playbold)),
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    ),
    guessedWordText = TextStyle(
        fontFamily = FontFamily(Font(R.font.playbold)),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold
    ),
    smallShowedWordText = TextStyle(
        fontFamily = FontFamily(Font(R.font.playbold)),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )


)

val LocalTypographyProvider = staticCompositionLocalOf<Typography> {
    error("No typography")
}