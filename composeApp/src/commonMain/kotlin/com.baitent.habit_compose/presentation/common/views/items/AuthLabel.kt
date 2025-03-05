package com.baitent.habit_compose.presentation.common.views.items

import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.baitent.habit_compose.R
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.theme.LocalColors


@Composable
fun AuthLabel(
    @StringRes titleId: Int,
    onClick: () -> Unit,
    @StringRes textButtonTitleId: Int
) {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.Bottom
    ) {
        Text(text = stringResource(id = titleId), style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.weight(1f))
        CustomTextButton(
            textId = textButtonTitleId,
            onClick = onClick,
            icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
            iconColor = LocalColors.current.primary
        )
    }
}


@Preview(showBackground = true)
@Composable
fun AuthLabelPreview() {
    AuthLabel(
        titleId = R.string.name,
        onClick = {},
        textButtonTitleId = R.string.signUp
    )
}