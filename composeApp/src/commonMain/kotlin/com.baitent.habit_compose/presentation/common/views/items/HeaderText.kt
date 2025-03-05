package com.baitent.habit_compose.presentation.common.views.items

import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.baitent.habit_compose.R
import com.baitent.habit_compose.presentation.features.common.constants.Dimens
import com.baitent.habit_compose.presentation.theme.Habit_composeTheme

@Composable
fun HeaderText(
    modifier: Modifier = Modifier,
    titleTextColor: Color = Color.Black,
    seeAllTextColor: Color = Color.Black,
    @StringRes titleText:Int,
    @StringRes seeAllText:Int?,
    onSeeAllClick: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(titleText),
            fontSize = Dimens.textSize20sp,
            fontWeight = FontWeight.Normal,
            color = titleTextColor,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        if(seeAllText != null){
            Text(
                text = stringResource(seeAllText),
                fontSize = Dimens.textSize14sp,
                textAlign = TextAlign.End,
                fontWeight = FontWeight.Normal,
                color = seeAllTextColor,
                modifier = Modifier.clickable { onSeeAllClick() }
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HeaderTextPreview(modifier: Modifier = Modifier) {
    Habit_composeTheme {
        HeaderText(
            titleTextColor = Color.Black,
            seeAllTextColor = Color.Black,
            titleText = R.string.TodayHabit,
            seeAllText = R.string.SeeAll,
            onSeeAllClick = {
            })
    }
}
