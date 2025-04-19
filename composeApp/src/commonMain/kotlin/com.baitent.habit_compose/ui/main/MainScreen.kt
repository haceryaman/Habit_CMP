import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.baitent.habit_compose.common.helpers.DateFormatterHelper
import com.baitent.habit_compose.common.helpers.GradientText
import com.baitent.habit_compose.presentation.common.views.components.HabitProgressCard

@Composable
fun MainScreen() {
    val todayText = remember { DateFormatterHelper.getTodayFormattedDate() }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = todayText,
            fontSize = 24.sp
        )
        Text(
            text = buildAnnotatedString {
                append("Hello, ")
                withStyle(GradientText.spanStyle()) {
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

    }
}