package com.baitent.habit_compose.presentation.features.common.views.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.presentation.features.common.constants.Dimens

data class CustomDropDownButtonData(
    val id: Int,
    val name: String
) {

}

@Composable
fun CustomDropdownButton(
    options: List<CustomDropDownButtonData>,
    dropdownTextColor: Color = Color.Red,
    buttonTextColor: Color = Color.White,
    buttonBackgroundColor: Color = Color.Black,
    dropdownBackgroundColor: Color = Color.Black,
    onSelected: (CustomDropDownButtonData) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(options[0].name) }
    onSelected(options[0])

    Box {
        Button(
            onClick = { expanded = true },
            shape = RoundedCornerShape(Dimens.rounded10dp),
            colors = ButtonDefaults.buttonColors().copy(
                contentColor = buttonTextColor,
                containerColor = buttonBackgroundColor
            )
        ) {
            Text(text = selectedOption, fontSize = Dimens.textSize14sp)
            Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "")
        }

        DropdownMenu(
            expanded = expanded,
            modifier = Modifier
                .background(dropdownBackgroundColor)
                .width(150.dp),
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = {
                        Text(
                            text = option.name, fontSize = Dimens.textSize14sp,
                            color = dropdownTextColor
                        )
                    },
                    onClick = {
                        onSelected(option)
                        selectedOption = option.name
                        expanded = false
                    }
                )
            }
        }
    }
}