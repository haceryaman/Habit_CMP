package com.baitent.habit_compose.presentation.common.views.custom

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.common.Dimens


@Composable
fun CustomCheckBox(
                   onChange:(Boolean) -> Unit,
                   isChecked:Boolean,
                   checkedBackgroundColor:List<Color> = listOf(Color.Green,Color.Yellow),
                   unCheckedBackgroundColor:List<Color> = listOf(Color.White),
                   checkedBorderColor:Color = Color.Black,
                   unCheckedBorderColor:Color = Color.Black,
                   checkedMarkColor:Color = Color.White,
                   unCheckedMarkColor:Color = Color.Black) {

    Box(modifier = Modifier
        .size(30.dp)
        .then(
            if (isChecked) {
                Modifier.background(
                    brush = Brush.linearGradient(checkedBackgroundColor),
                    shape = RoundedCornerShape(Dimens.rounded30dp)
                )
            } else Modifier.background(
                brush = Brush.linearGradient(unCheckedBackgroundColor),
                shape = RoundedCornerShape(Dimens.rounded30dp)
            )
        )
        .then(
            if (isChecked) Modifier.border(
                BorderStroke(2.dp, checkedBorderColor),
                shape = RoundedCornerShape(Dimens.rounded30dp)
            )
            else Modifier.border(
                BorderStroke(2.dp, unCheckedBorderColor),
                shape = RoundedCornerShape(Dimens.rounded30dp)
            )
        )
        .clickable {
            onChange(!isChecked)
        }
        .padding(Dimens.padding4dp), contentAlignment = Alignment.Center){
        if(isChecked){
            Icon(imageVector = Icons.Default.Check,
                tint = if(isChecked) checkedMarkColor else unCheckedMarkColor,
                contentDescription = "")
        }
    }
}