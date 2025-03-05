package com.baitent.habit_compose.presentation.common.views.items

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.theme.LocalColors


@Composable
fun AuthLabel(
    title: String,
    onClick: () -> Unit,
    textButtonTitle: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom
    ) {
        Text(text = title, style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        CustomTextButton(
            text = textButtonTitle,
            onClick = onClick,
            icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
            iconColor = LocalColors.current.primary
        )
    }
}
