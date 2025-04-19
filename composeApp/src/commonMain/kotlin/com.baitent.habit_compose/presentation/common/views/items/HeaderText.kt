package com.baitent.habit_compose.presentation.common.views.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.baitent.habit_compose.common.Dimens

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    titleTextColor: Color = Color.Black,
    seeAllTextColor: Color = Color.Black,
    titleText:String,
    seeAllText:String?,
    onSeeAllClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = titleText,
            fontSize = Dimens.textSize20sp,
            fontWeight = FontWeight.Normal,
            color = titleTextColor,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        if(seeAllText != null){
            Text(
                text = seeAllText,
                fontSize = Dimens.textSize14sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Normal,
                color = seeAllTextColor,
                modifier = Modifier.clickable { onSeeAllClick() }
            )
        }
    }
}