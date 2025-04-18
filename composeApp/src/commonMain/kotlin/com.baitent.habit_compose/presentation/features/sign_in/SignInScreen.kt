package com.baitent.habit_compose.presentation.features.sign_in

import CustomButton
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
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.baitent.habit_compose.presentation.common.views.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.email
import habit_compose.composeapp.generated.resources.emailError
import habit_compose.composeapp.generated.resources.emailPlaceholder
import habit_compose.composeapp.generated.resources.forgotPassword
import habit_compose.composeapp.generated.resources.orLoginWith
import habit_compose.composeapp.generated.resources.orSignUpWith
import habit_compose.composeapp.generated.resources.password
import habit_compose.composeapp.generated.resources.passwordError
import habit_compose.composeapp.generated.resources.passwordPlaceholder
import habit_compose.composeapp.generated.resources.rememberMe
import habit_compose.composeapp.generated.resources.signIn
import habit_compose.composeapp.generated.resources.signUp
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignInScreen(
    onSignUpClick: () -> Unit,
    onSignInClick: () -> Unit,
    onGoogleSignUpClick: () -> Unit,

){
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        AuthLabel(
            title = stringResource(Res.string.signIn),
            onClick = onSignUpClick,
            textButtonTitle = stringResource(Res.string.signUp)
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        TextFieldItem(
            label = stringResource(Res.string.email),
            placeholderId = stringResource(Res.string.emailPlaceholder),
            errorMessageId = stringResource(Res.string.emailError),
            isPassword = false,
            onValueChanged = {},
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = stringResource(Res.string.password),
            placeholderId = stringResource(Res.string.passwordPlaceholder),
            errorMessageId = stringResource(Res.string.passwordError),
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
                    text = stringResource(Res.string.rememberMe),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            CustomTextButton(
                text = stringResource(Res.string.forgotPassword),
                onClick = onSignUpClick,
                icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
                iconColor = LocalColors.current.white
            )
        }
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        CustomButton(
            text = stringResource(Res.string.signIn),
            onClick = {  }
        )
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = stringResource(Res.string.orSignUpWith),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))

        CustomButton(
            text = null,
            icon = Icons.Outlined.Settings,
            onClick = onGoogleSignUpClick
        )
        Spacer(modifier = Modifier.weight(1f))

    }
}
