package com.pidzama.firstframe.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pidzama.firstframe.R

val Glober = FontFamily(
    Font(R.font.glober, FontWeight.Normal),
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 57.sp,
        lineHeight = 64.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 45.sp,
        lineHeight = 52.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 22.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 16.sp,
        letterSpacing = 1.sp
    ),
    titleSmall = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp,
    ),
    labelLarge = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 12.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    bodySmall = TextStyle(
        fontFamily = Glober,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        letterSpacing = 0.4.sp
    ),
)