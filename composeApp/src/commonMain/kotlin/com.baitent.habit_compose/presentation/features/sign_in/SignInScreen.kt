package com.baitent.habit_compose.presentation.features.sign_in

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.baitent.habit_compose.R
import com.baitent.habit_compose.presentation.common.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors


@Composable
fun SigninScreen(
    onSignInClick: () -> Unit = {},
){
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        AuthLabel(
            titleId = R.string.signIn,
            onClick = onSignInClick,
            textButtonTitleId = R.string.signUp
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        TextFieldItem(
            labelId = R.string.email,
            placeholderId = R.string.emailPlaceholder,
            errorMessageId = R.string.emailError,
            isPassword = false,
            onValueChanged = {},
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            labelId = R.string.password,
            placeholderId = R.string.passwordPlaceholder,
            errorMessageId = R.string.passwordError,
            isPassword = false,
            onValueChanged = {},
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Checkbox(
                    colors = CheckboxDefaults.colors(
                        checkedColor = LocalColors.current.secondaryVariant,
                    ),
                    checked = true,
                    onCheckedChange = { },
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(AppDimensions.smallSpace))
                Text(
                    text = stringResource(R.string.rememberMe),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            CustomTextButton(
                textId = R.string.forgotPassword,
                onClick = {},
                icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
                iconColor = LocalColors.current.white
            )
        }
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        CustomButton(
            text = stringResource(R.string.signIn),
            onClick = {  }
        )
        CustomTextButton(
            textId = R.string.orLoginWith,
            onClick = {},
            icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
            iconColor = LocalColors.current.white
        )

    }
}

@Preview(showBackground = true)
@Composable
fun SigninScreenPreview(){
    SigninScreen(
        onSignInClick = {  }
    )
}

