package com.baitent.habit_compose.presentation.common.views.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.common.Dimens
import com.baitent.habit_compose.presentation.common.views.custom.CustomCheckBox
import com.baitent.habit_compose.presentation.theme.LocalColors

data class HabitItemData(
    val id: String,
    val title: String,
    var isChecked: Boolean,
)

@Composable
fun HabitItem(
    data: HabitItemData,
    onCheckedChange: (HabitItemData) -> Unit
) {
    val colors = LocalColors.current

    var checked by remember { mutableStateOf(data.isChecked) }

    val backgroundColor = if (checked) colors.secondaryVariant else colors.background
    val textColor       = if (checked) colors.white else colors.black

    val checkboxBackground = if (checked)
        listOf(colors.primary, colors.secondary)
    else
        listOf(Color.Gray, colors.lightGray)
    val checkboxBorder = Color.Transparent
    val checkboxMark   = if (checked) Color.White else Color.Black

    val itemShape = RoundedCornerShape(Dimens.rounded10dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor, shape = itemShape)
            .padding(
                vertical   = Dimens.padding16dp,
                horizontal = Dimens.padding12dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text       = data.title,
            color      = textColor,
            fontSize   = Dimens.textSize12sp,
            fontWeight = FontWeight.SemiBold,
            modifier   = Modifier.weight(1f)
        )

        CustomCheckBox(
            isChecked               = checked,
            onChange                = { new ->
                checked = new
                data.isChecked = new
                onCheckedChange(data)
            },
            checkedBackgroundColor   = checkboxBackground,
            unCheckedBackgroundColor = checkboxBackground,
            checkedBorderColor       = checkboxBorder,
            unCheckedBorderColor     = checkboxBorder,
            checkedMarkColor         = checkboxMark,
            cornerRadius             = Dimens.rounded10dp.value.toInt(),
            sizeDp                   = 24,
            borderWidthDp            = 2,
            paddingDp                = 4
        )

        Icon(
            imageVector   = Icons.Default.MoreVert,
            contentDescription = null,
            tint          = colors.lightGray,
            modifier      = Modifier
                .padding(start = Dimens.padding8dp)
                .size(24.dp)
        )
    }
}