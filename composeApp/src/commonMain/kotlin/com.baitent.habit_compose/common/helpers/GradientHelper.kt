package com.baitent.habit_compose.common.helpers

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object GradientText {
    val DefaultBrush: Brush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFFA450),
            Color(0xFFFF5C00)
        )
    )

    fun spanStyle(
        fontSize: TextUnit = 28.sp,
        fontWeight: FontWeight = FontWeight.Bold,
        brush: Brush = DefaultBrush
    ): SpanStyle = SpanStyle(
        brush = brush,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
}
