package com.baitent.habit_compose.presentation.common.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


enum class Period(val label: String) {
    OneWeek("1 Week (7 Days)"),
    OneMonth("1 Month (30 Days)"),
    ThreeMonths("3 Months (90 Days)")
}

enum class HabitType(val label: String) {
    Everyday("Everyday"),
    Weekdays("Weekdays"),
    Weekend("Weekend")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateHabitDialog(
    // MVI’den gelen state ve lambda’lar:
    goalText: String,
    onGoalChange: (String) -> Unit,
    habitName: String,
    onNameChange: (String) -> Unit,
    periodLabel: String,
    expandedPeriod: Boolean,
    onTogglePeriod: () -> Unit,
    onSelectPeriod: (Period) -> Unit,
    typeLabel: String,
    expandedType: Boolean,
    onToggleType: () -> Unit,
    onSelectType: (HabitType) -> Unit,

    // Sadece dialog kontrolü:
    onDismissRequest: () -> Unit,
    onCreate: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .width(360.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Create New Habit Goal", style = MaterialTheme.typography.titleLarge)
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { onDismissRequest() }
                    )
                }

                Spacer(Modifier.height(12.dp))
                Text("Your Goal", style = MaterialTheme.typography.bodyMedium)
                OutlinedTextField(
                    value = goalText,
                    onValueChange = onGoalChange,
                    placeholder = { Text("Enter your goal") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))
                Text("Habit Name", style = MaterialTheme.typography.bodyMedium)
                OutlinedTextField(
                    value = habitName,
                    onValueChange = onNameChange,
                    placeholder = { Text("e.g. Drink water") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(12.dp))
                Text("Period", style = MaterialTheme.typography.bodyMedium)
                ExposedDropdownMenuBox(
                    expanded = expandedPeriod,
                    onExpandedChange = { onTogglePeriod() }
                ) {
                    OutlinedTextField(
                        value = periodLabel,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedPeriod) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(type = MenuAnchorType.PrimaryEditable)
                    )
                    ExposedDropdownMenu(
                        expanded = expandedPeriod,
                        onDismissRequest = { onTogglePeriod() }
                    ) {
                        Period.entries.forEach { p ->
                            DropdownMenuItem(
                                text = { Text(p.label) },
                                onClick = { onSelectPeriod(p) }
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))
                Text("Habit Type", style = MaterialTheme.typography.bodyMedium)
                ExposedDropdownMenuBox(
                    expanded = expandedType,
                    onExpandedChange = { onToggleType() }
                ) {
                    OutlinedTextField(
                        value = typeLabel,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedType) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(type = MenuAnchorType.PrimaryEditable)
                    )
                    ExposedDropdownMenu(
                        expanded = expandedType,
                        onDismissRequest = { onToggleType() }
                    ) {
                        HabitType.entries.forEach { t ->
                            DropdownMenuItem(
                                text = { Text(t.label) },
                                onClick = { onSelectType(t) }
                            )
                        }
                    }
                }

                Spacer(Modifier.height(24.dp))
                val gradient = Brush.horizontalGradient(
                    colors = listOf(Color(0xFFF37335), Color(0xFFFF8C00))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(gradient)
                        .clickable { onCreate() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("Create Habit", color = Color.White, style = MaterialTheme.typography.bodyLarge)
                }
            }
        }
    }
}
