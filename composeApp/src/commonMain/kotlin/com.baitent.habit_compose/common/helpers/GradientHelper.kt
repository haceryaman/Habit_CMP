package com.baitent.habit_compose.common.helpers

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

object GradientText {
    private val DefaultBrush: Brush = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFEE7752),
            Color(0xFF23A6D5)
        )
    )

    fun spanStyle(
        fontSize: TextUnit = 16.sp,
        fontWeight: FontWeight = FontWeight.Bold,
        brush: Brush = DefaultBrush
    ): SpanStyle = SpanStyle(
        brush = brush,
        fontSize = fontSize,
        fontWeight = fontWeight
    )
}
