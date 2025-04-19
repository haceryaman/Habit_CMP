package com.baitent.habit_compose.presentation.common.views.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun CustomCheckBox(
    onChange: (Boolean) -> Unit,
    isChecked: Boolean,
    checkedBackgroundColor: List<Color> = listOf(Color.Green, Color.Yellow),
    unCheckedBackgroundColor: List<Color> = listOf(Color.White),
    checkedBorderColor: Color = Color.Black,
    unCheckedBorderColor: Color = Color.Black,
    checkedMarkColor: Color = Color.White,
    cornerRadius: Int = 8,
    sizeDp: Int = 30,
    borderWidthDp: Int = 2,
    paddingDp: Int = 4
) {
    val shape = RoundedCornerShape(cornerRadius.dp)
    val brush = if (isChecked)
        Brush.linearGradient(checkedBackgroundColor)
    else
        Brush.linearGradient(unCheckedBackgroundColor)
    val borderColor = if (isChecked) checkedBorderColor else unCheckedBorderColor

    Box(
        modifier = Modifier
            .size(sizeDp.dp)
            .background(brush = brush, shape = shape)
            .border(BorderStroke(borderWidthDp.dp, borderColor), shape = shape)
            .clickable { onChange(!isChecked) }
            .padding(paddingDp.dp),
        contentAlignment = Alignment.Center
    ) {
        if (isChecked) {
            Icon(
                imageVector = Icons.Default.Check,
                tint = checkedMarkColor,
                contentDescription = null
            )
        }
    }
}