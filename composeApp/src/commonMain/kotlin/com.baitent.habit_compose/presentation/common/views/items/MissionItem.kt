package com.baitent.habit_compose.presentation.common.views.items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.baitent.habit_compose.common.Dimens
import com.baitent.habit_compose.presentation.common.views.custom.CustomCheckBox
import com.baitent.habit_compose.presentation.theme.LocalColors


data class MissionItemData(
    val id:String,
    val title:String,
    var isChecked:Boolean,
)

@Composable
fun MissionItem(
    data: MissionItemData,
    onClick:(MissionItemData) -> Unit
) {
    val colors = LocalColors.current

    val textColorChecked = colors.white
    val textColorUnChecked = colors.black

    val bgColorChecked = colors.secondaryVariant
    val bgColorUnChecked = colors.background

    val checkedBackgroundColor = listOf(colors.primary, colors.secondary)
    val unCheckedBackgroundColor = listOf(Color.Gray, Color.DarkGray)

    val checkedBorderColor =  colors.transparent
    val unCheckedBorderColor = colors.transparent

    val checkedMarkColor = Color.White
    val unCheckedMarkColor = Color.Black

    val moreCheckColor =  colors.darkGray
    val moreUnCheckColor = colors.darkGray

    var isChecked by remember {
        mutableStateOf(data.isChecked)
    }

    Row(modifier = Modifier.fillMaxWidth()
        .background(
            if(isChecked) bgColorChecked
            else bgColorUnChecked,
            shape = RoundedCornerShape(Dimens.rounded10dp)
        )
        .padding(vertical = Dimens.padding16dp, horizontal = Dimens.padding12dp),
        verticalAlignment = Alignment.CenterVertically) {

        Text(text = data.title,
            color = if(isChecked) textColorChecked else textColorUnChecked,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f),
            fontSize = Dimens.textSize12sp
        )

        CustomCheckBox(
            onChange = {
                isChecked = !isChecked
                data.isChecked = isChecked
                onClick(data)
            },
            isChecked = isChecked,
            checkedBackgroundColor = checkedBackgroundColor,
            unCheckedBackgroundColor = unCheckedBackgroundColor,
            checkedBorderColor = checkedBorderColor,
            unCheckedBorderColor = unCheckedBorderColor,
            checkedMarkColor = checkedMarkColor,
            unCheckedMarkColor = unCheckedMarkColor
        )

        Spacer(modifier = Modifier.size(Dimens.padding4dp))
        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")
    }
}