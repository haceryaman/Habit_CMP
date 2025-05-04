import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baitent.habit_compose.common.helpers.DateFormatterHelper
import com.baitent.habit_compose.common.helpers.GradientText
import com.baitent.habit_compose.presentation.common.views.components.CardTodayHabitComponent
import com.baitent.habit_compose.presentation.common.views.components.CreateHabitDialog
import com.baitent.habit_compose.presentation.common.views.components.HabitProgressCard
import com.baitent.habit_compose.presentation.common.views.components.YourGoalsComponent
import com.baitent.habit_compose.presentation.common.views.items.HabitItemData
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun MainScreen() {
    var showDialog by remember { mutableStateOf(false) }
    val todayText = remember { DateFormatterHelper.getTodayFormattedDate() }
    val colors = LocalColors.current

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = LocalColors.current.background,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .size(56.dp)
                    .border(
                        width = 2.dp,
                        color = Color.White,
                        shape = CircleShape
                    ),
                shape = CircleShape,
                onClick = {
                    showDialog = true
                },
                containerColor = LocalColors.current.primary,
                elevation = FloatingActionButtonDefaults.elevation(0.dp),
            ) {
                Icon(Icons.Default.Add, contentDescription = "")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        Column(
            modifier = Modifier.fillMaxSize().background(color = colors.background),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = todayText,
                fontSize = 24.sp
            )
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        SpanStyle(fontSize = 28.sp)
                    ) {
                        append("Hello, ")
                    }
                    withStyle(
                        GradientText.spanStyle(fontSize = 28.sp)
                    ) {
                        append("User!")
                    }
                }
            )
            HabitProgressCard(
                progress = 0.7f,
                completed = 3,
                total = 5,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            CardTodayHabitComponent(
                habits = listOf(
                    HabitItemData(id = "1", title = "jadha", isChecked = false),
                    HabitItemData(id = "2", title = "jaeefefdha", isChecked = true)
                )
            )

            YourGoalsComponent(
                allGoals = listOf(
                    HabitItemData(id = "1", title = "", isChecked = false),
                    HabitItemData(id = "2", title = "", isChecked = true)
                )
            )

        }
        if (showDialog) {
            CreateHabitDialog(
                onDismissRequest = { showDialog = false },
                onCreate = { goal, name, period, type ->
                    println("Goal=$goal, Name=$name, Period=$period, Type=$type")
                    showDialog = false
                }
            )
        }
    }
}