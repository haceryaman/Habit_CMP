package com.baitent.habit_compose.presentation.common.views.items

import CustomTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldItem(
    label: String,
    placeholderId: String,
    errorMessageId: String,
    isPassword: Boolean,
    isError: Boolean= false,
    onValueChanged: (String) -> Unit,
    value: String,

    ) {
    Column {
        Text(label, style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            label = label,
            placeholder = placeholderId,
            value = value,
            onValueChange = onValueChanged,
            isPassword = isPassword,
            isError = isError,
            errorMessage = errorMessageId,
        )
    }
}