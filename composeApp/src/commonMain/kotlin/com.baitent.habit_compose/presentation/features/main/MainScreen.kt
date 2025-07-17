import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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
import com.baitent.habit_compose.presentation.features.main.MainContract
import com.baitent.habit_compose.presentation.theme.LocalColors
import kotlinx.coroutines.flow.Flow

@Composable
fun MainScreen(
    uiState: MainContract.UiState,
    uiEffect: Flow<MainContract.UiEffect>,
    onAction: (MainContract.UiAction) -> Unit,
    ) {
    var showDialog by remember { mutableStateOf(false) }
    val todayText = remember { DateFormatterHelper.getTodayFormattedDate() }
    val scrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }


    LaunchedEffect(uiEffect) {
        uiEffect.collect { effect ->
            when (effect) {
                is MainContract.UiEffect.HabitCreated ->
                    snackbarHostState.showSnackbar("Yeni habit oluşturuldu!")

                is MainContract.UiEffect.Error ->
                    snackbarHostState.showSnackbar(effect.message)

            }
        }
    }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = LocalColors.current.background,
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .size(56.dp)
                    .border(
                        width = 2.dp,
                        color = LocalColors.current.secondaryVariant,
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
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
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
        if (uiState.showDialog) {
            CreateHabitDialog(
                goalText       = uiState.goalText,
                onGoalChange   = { text -> coroutineScope.launch { onAction(SetGoal(text)) } },
                habitName      = uiState.habitName,
                onNameChange   = { name -> coroutineScope.launch { onAction(SetName(name)) } },
                periodLabel    = uiState.selectedPeriod.label,
                expandedPeriod = uiState.expandedPeriod,
                onTogglePeriod = { coroutineScope.launch { onAction(TogglePeriodDropdown) } },
                onSelectPeriod = { p -> coroutineScope.launch { onAction(SelectPeriod(p)) } },
                typeLabel      = uiState.selectedType.label,
                expandedType   = uiState.expandedType,
                onToggleType   = { coroutineScope.launch { onAction(ToggleTypeDropdown) } },
                onSelectType   = { t -> coroutineScope.launch { onAction(SelectType(t)) } },

                onDismissRequest = { coroutineScope.launch { onAction(DismissDialog) } },
                onCreate         = { coroutineScope.launch { onAction(CreateClicked) } }
            )
        }
    }
}
