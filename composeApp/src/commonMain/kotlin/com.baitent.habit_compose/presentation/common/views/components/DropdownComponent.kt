package com.baitent.habit_compose.presentation.features.common.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.baitent.habit_compose.common.Dimens
import com.baitent.habit_compose.presentation.common.views.custom.CustomDropDownButtonData
import com.baitent.habit_compose.presentation.common.views.custom.CustomDropdownButton


@Composable
fun DropdownButtonComponent(
    title: String,
    titleColor: Color = Color.Red,
    backgroundColor: Color = Color.White,
    items: List<CustomDropDownButtonData>
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(backgroundColor)
                .padding(horizontal = Dimens.padding16dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = title,
                color = titleColor,
                fontSize = Dimens.textSize12sp
            )

            CustomDropdownButton(
                options = items,
                onSelected = {
                }
            )
        }
    }
}