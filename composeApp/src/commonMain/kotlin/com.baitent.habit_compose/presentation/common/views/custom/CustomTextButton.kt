package com.baitent.habit_compose.presentation.common.views.custom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun CustomTextButton(
     text: String,
    onClick: () -> Unit,
    icon: ImageVector,
    iconColor: Color
) {
    Row(
        modifier = Modifier
            .clickable { onClick() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    )  {
        Text(
            text = text,
            style = MaterialTheme.typography.labelLarge.copy(
                color = LocalColors.current.primary,
                fontWeight = MaterialTheme.typography.labelLarge.fontWeight
            )
        )
        IconButton(
            modifier = Modifier.size(24.dp),
            onClick = {}
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "Arrow Forward",
                tint = iconColor
            )
        }

    }
}