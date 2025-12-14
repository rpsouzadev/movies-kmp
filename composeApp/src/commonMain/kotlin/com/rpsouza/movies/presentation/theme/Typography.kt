package com.rpsouza.movies.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import movies.composeapp.generated.resources.Res
import movies.composeapp.generated.resources.urbanist_400
import movies.composeapp.generated.resources.urbanist_500
import movies.composeapp.generated.resources.urbanist_600
import movies.composeapp.generated.resources.urbanist_700
import org.jetbrains.compose.resources.Font

val urbanist: FontFamily
    @Composable get() = FontFamily(
        Font(Res.font.urbanist_400, FontWeight.Normal),
        Font(Res.font.urbanist_500, FontWeight.Medium),
        Font(Res.font.urbanist_600, FontWeight.SemiBold),
        Font(Res.font.urbanist_700, FontWeight.Bold),
    )

@Composable
fun AppTypography() = Typography(
    displaySmall = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = urbanist,
    ),
    headlineLarge = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = urbanist,
    ),
    titleLarge = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = urbanist,
    ),
    titleMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = urbanist,
    ),
    titleSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = urbanist,
    ),
    bodyLarge = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = urbanist,
    ),
    bodyMedium = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = urbanist,
    ),
    bodySmall = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = urbanist,
    ),
)