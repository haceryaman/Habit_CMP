package com.baitent.habit_compose.presentation.common.views.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
    onDismissRequest: () -> Unit,
    onCreate: (goal: String, name: String, period: Period, type: HabitType) -> Unit
) {
    var goalText by remember { mutableStateOf("") }
    var habitName by remember { mutableStateOf("") }
    var expandedPeriod by remember { mutableStateOf(false) }
    var expandedType by remember { mutableStateOf(false) }
    var selectedPeriod by remember { mutableStateOf(Period.OneMonth) }
    var selectedType by remember { mutableStateOf(HabitType.Everyday) }

    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .width(360.dp)
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),

            ) {
            Column(modifier = Modifier.background(Color.White).padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Create New Habit Goal", style = MaterialTheme.typography.titleLarge)
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { onDismissRequest() }
                    )
                }

                Spacer(Modifier.height(8.dp))
                HorizontalDivider()
                Spacer(Modifier.height(16.dp))

                // Your Goal
                Text("Your Goal", style = MaterialTheme.typography.bodyMedium)
                OutlinedTextField(
                    value = goalText,
                    onValueChange = { goalText = it },
                    placeholder = { Text("Enter your goal") },
                    modifier = Modifier.fillMaxWidth(),

                    )
                Spacer(Modifier.height(12.dp))

                // Habit Name
                Text("Habit Name", style = MaterialTheme.typography.bodyMedium)
                OutlinedTextField(
                    value = habitName,
                    onValueChange = { habitName = it },
                    placeholder = { Text("e.g. Drink water") },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ExposedDropdownMenuDefaults.textFieldColors(

                    )
                )
                Spacer(Modifier.height(12.dp))

                // Period Dropdown
                Text("Period", style = MaterialTheme.typography.bodyMedium)
                ExposedDropdownMenuBox(
                    expanded = expandedPeriod,
                    onExpandedChange = { expandedPeriod = !expandedPeriod }
                ) {
                    OutlinedTextField(
                        value = selectedPeriod.label,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedPeriod) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(type = MenuAnchorType.PrimaryEditable)          // ← Burayı ekleyin
                    )
                    ExposedDropdownMenu(
                        expanded = expandedPeriod,
                        onDismissRequest = { expandedPeriod = false }
                    ) {
                        Period.entries.forEach { p ->
                            DropdownMenuItem(
                                text = { Text(p.label) },
                                onClick = {
                                    selectedPeriod = p
                                    expandedPeriod = false
                                }
                            )
                        }
                    }
                }

                Spacer(Modifier.height(12.dp))

                // Habit Type Dropdown
                Text("Habit Type", style = MaterialTheme.typography.bodyMedium)
                ExposedDropdownMenuBox(
                    expanded = expandedType,
                    onExpandedChange = { expandedType = !expandedType }
                ) {
                    OutlinedTextField(
                        value = selectedType.label,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expandedType) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor(type = MenuAnchorType.PrimaryEditable)          // ← Ve burada da
                    )
                    ExposedDropdownMenu(
                        expanded = expandedType,
                        onDismissRequest = { expandedType = false }
                    ) {
                        HabitType.values().forEach { t ->
                            DropdownMenuItem(
                                text = { Text(t.label) },
                                onClick = {
                                    selectedType = t
                                    expandedType = false
                                }
                            )
                        }
                    }
                }

                Spacer(Modifier.height(20.dp))

                val gradient = Brush.horizontalGradient(
                    colors = listOf(Color(0xFFF37335), Color(0xFFFF8C00))
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(gradient)
                        .clickable {
                            onCreate(goalText, habitName, selectedPeriod, selectedType)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        "Create Habit",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.White
                    )
                }
            }
        }
    }
}
