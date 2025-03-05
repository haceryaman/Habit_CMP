package com.baitent.habit_compose.presentation.features.common.views.components

import android.widget.Toast
import androidx.annotation.StringRes
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.baitent.habit_compose.presentation.features.common.constants.Dimens
import com.baitent.habit_compose.presentation.features.common.views.custom.CustomDropDownButtonData
import com.baitent.habit_compose.presentation.features.common.views.custom.CustomDropdownButton


@Composable
fun DropdownButtonComponent(
    @StringRes title: Int,
    titleColor: Color = Color.Red,
    backgroundColor: Color = Color.White,
    items: List<CustomDropDownButtonData>
) {
    val context = LocalContext.current

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
                text = stringResource(title),
                color = titleColor,
                fontSize = Dimens.textSize12sp
            )

            CustomDropdownButton(
                options = items,
                onSelected = {
                    Toast.makeText(context, it.name, Toast.LENGTH_SHORT).show()
                }
            )
        }
    }
}