package com.baitent.habit_compose.presentation.features.common.views.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.R
import com.baitent.habit_compose.presentation.features.common.DummyData
import com.baitent.habit_compose.presentation.features.common.constants.Dimens
import com.baitent.habit_compose.presentation.common.views.items.HeaderText
import com.baitent.habit_compose.presentation.common.views.items.MissionItem
import com.baitent.habit_compose.presentation.common.views.items.MissionItemData
import com.baitent.habit_compose.presentation.theme.Habit_composeTheme
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun CardTodayHabitComponent(modifier: Modifier = Modifier,
                            habits:List<MissionItemData>,
                            onClick:(MissionItemData) -> Unit
)
{
    val context = LocalContext.current
    val colors = LocalColors.current

    Card(modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White
        )) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = Dimens.padding16dp)) {
            Spacer(modifier = Modifier.size(22.dp))

            HeaderText(
                modifier = Modifier,
                titleTextColor = Color.Black,
                seeAllTextColor = Color.Cyan,
                titleText = R.string.TodayHabit,
                seeAllText = R.string.SeeAll
            ) {
                Toast.makeText(context,"tık",Toast.LENGTH_LONG).show()
            }

            Spacer(modifier = Modifier.size(Dimens.padding16dp))

            habits.forEachIndexed { index, habitItem ->
                MissionItem (
                    data = habitItem
                ){
                    Toast.makeText(context,"${habitItem.id} ${habitItem.isChecked}",Toast.LENGTH_LONG).show()
                }
                Spacer(modifier = Modifier.size(Dimens.padding4dp))
            }
            Spacer(modifier = Modifier.size(Dimens.padding16dp))
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CardTodayHabitComponentPreview(modifier: Modifier = Modifier) {
    Habit_composeTheme {
        CardTodayHabitComponent(modifier = Modifier, habits =
        DummyData.getHabits()){

        }
    }
}