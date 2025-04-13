package com.baitent.habit_compose.presentation.common.views.components

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
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.common.Dimens
import com.baitent.habit_compose.presentation.common.views.items.HeaderText
import com.baitent.habit_compose.presentation.common.views.items.MissionItem
import com.baitent.habit_compose.presentation.common.views.items.MissionItemData
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.password
import habit_compose.composeapp.generated.resources.seeAll
import org.jetbrains.compose.resources.stringResource

@Composable
fun CardTodayHabitComponent(habits: List<MissionItemData>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White
        )
    ) {
        Column(modifier = Modifier.fillMaxWidth().padding(horizontal = Dimens.padding16dp)) {
            Spacer(modifier = Modifier.size(22.dp))

            HeaderText(
                modifier = Modifier,
                titleTextColor = Color.Black,
                seeAllTextColor = Color.Cyan,
                titleText = stringResource(Res.string.password),
                seeAllText = stringResource(Res.string.seeAll),
            ) {
            }

            Spacer(modifier = Modifier.size(Dimens.padding16dp))

            habits.forEachIndexed { _, habitItem ->
                MissionItem(
                    data = habitItem
                ) {
                }
                Spacer(modifier = Modifier.size(Dimens.padding4dp))
            }
            Spacer(modifier = Modifier.size(Dimens.padding16dp))
        }
    }
}