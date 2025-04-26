package com.baitent.habit_compose.common

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.manrope_bold
import habit_compose.composeapp.generated.resources.manrope_light
import habit_compose.composeapp.generated.resources.manrope_regular
import habit_compose.composeapp.generated.resources.worksans_bold
import habit_compose.composeapp.generated.resources.worksans_italic
import habit_compose.composeapp.generated.resources.worksans_medium
import habit_compose.composeapp.generated.resources.worksans_regular
import habit_compose.composeapp.generated.resources.worksans_thin


@Composable
fun manropeFontFamily() = FontFamily(
    Font(Res.font.manrope_regular, weight = FontWeight.Normal),
    Font(Res.font.manrope_bold, weight = FontWeight.Bold),
    Font(Res.font.manrope_light, weight = FontWeight.Light),
)

@Composable
fun worksansFontFamily() = FontFamily(
    Font(Res.font.worksans_regular),
    Font(Res.font.worksans_medium, weight = FontWeight.Medium),
    Font(Res.font.worksans_bold, weight = FontWeight.Bold),
    Font(Res.font.worksans_thin, weight = FontWeight.Thin),
    Font(Res.font.worksans_italic, style = FontStyle.Italic)
)

@Composable
fun HabitTypography() = Typography(
    // Display
    displayLarge   = TextStyle(fontFamily = worksansFontFamily(), fontSize = 57.sp),
    displayMedium  = TextStyle(fontFamily = worksansFontFamily(), fontSize = 45.sp),
    displaySmall   = TextStyle(fontFamily = worksansFontFamily(), fontSize = 36.sp),

    // Headline
    headlineLarge  = TextStyle(fontFamily = worksansFontFamily(), fontSize = 32.sp),
    headlineMedium = TextStyle(fontFamily = worksansFontFamily(), fontSize = 28.sp),
    headlineSmall  = TextStyle(fontFamily = worksansFontFamily(), fontSize = 24.sp),

    // Title
    titleLarge     = TextStyle(fontFamily = worksansFontFamily(), fontSize = 22.sp),
    titleMedium    = TextStyle(fontFamily = worksansFontFamily(), fontSize = 16.sp),
    titleSmall     = TextStyle(fontFamily = worksansFontFamily(), fontSize = 14.sp),

    // Body
    bodyLarge      = TextStyle(fontFamily = manropeFontFamily(),   fontSize = 16.sp),
    bodyMedium     = TextStyle(fontFamily = manropeFontFamily(),   fontSize = 14.sp),
    bodySmall      = TextStyle(fontFamily = manropeFontFamily(),   fontSize = 12.sp),

    // Label
    labelLarge     = TextStyle(fontFamily = manropeFontFamily(),   fontSize = 14.sp),
    labelMedium    = TextStyle(fontFamily = manropeFontFamily(),   fontSize = 12.sp),
    labelSmall     = TextStyle(fontFamily = manropeFontFamily(),   fontSize = 11.sp),
)