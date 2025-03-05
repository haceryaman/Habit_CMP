package com.baitent.habit_compose.presentation.common.items

import CustomTextField
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun TextFieldItem(
    @StringRes labelId: Int,
    @StringRes placeholderId: Int,
    @StringRes errorMessageId: Int,
    isPassword: Boolean,
    isError: Boolean= false,
    onValueChanged: (String) -> Unit,
    value: String,

    ) {
    Column {
        Text(stringResource(id=labelId), style = MaterialTheme.typography.labelLarge)
        Spacer(modifier = Modifier.height(8.dp))
        CustomTextField(
            labelId = labelId,
            placeholderId = placeholderId,
            value = value,
            onValueChange = onValueChanged,
            isPassword = isPassword,
            isError = isError,
            errorMessageId = errorMessageId,
        )
    }
}