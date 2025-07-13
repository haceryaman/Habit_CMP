package com.baitent.habit_compose.presentation.common.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baitent.habit_compose.common.Dimens
import com.baitent.habit_compose.presentation.common.views.items.HeaderText
import com.baitent.habit_compose.presentation.common.views.items.HabitItem
import com.baitent.habit_compose.presentation.common.views.items.HabitItemData
import com.baitent.habit_compose.presentation.theme.LocalColors
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.TodayHabit
import habit_compose.composeapp.generated.resources.showAll
import habit_compose.composeapp.generated.resources.yourGoals
import org.jetbrains.compose.resources.stringResource

@Composable
fun YourGoalsComponent(allGoals: List<HabitItemData>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors().copy(
            containerColor = Color.White
        )
    ) {
        val colors = LocalColors.current

        Column(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.size(22.dp))

            HeaderText(
                modifier = Modifier,
                titleTextColor = Color.Black,
                seeAllTextColor = colors.primary,
                titleText = stringResource(Res.string.yourGoals),
                seeAllText = null,
            ) {
            }

            Spacer(modifier = Modifier.size(Dimens.padding16dp))

            allGoals.forEachIndexed { _, goalItem ->
                GoalCard(
                    title = "Finish 5 Philosophy Books",
                    progressFraction = 5f / 7f,
                    progressText = "5 from 7 days target",
                    frequencyText = "Everyday",
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Spacer(modifier = Modifier.size(Dimens.padding4dp))
            }
            Spacer(modifier = Modifier.size(Dimens.padding16dp))
        }
    }
}

@Composable
fun GoalCard(
    title: String,
    progressFraction: Float,
    progressText: String,
    frequencyText: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF9F9F9)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.1.dp)
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
        ) {
            // Header Row
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    tint = Color.Gray
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .background(
                        color = Color(0xFFE0E0E0),
                        shape = RoundedCornerShape(2.dp)
                    )
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(progressFraction)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color(0xFFFFA726), Color(0xFFFF5722))
                            ),
                            shape = RoundedCornerShape(2.dp)
                        )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = progressText,
                fontSize = 14.sp,
                color = Color.DarkGray
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = frequencyText,
                fontSize = 14.sp,
                color = Color(0xFFFF5722),
                fontWeight = FontWeight.Medium
            )
        }
    }
}
