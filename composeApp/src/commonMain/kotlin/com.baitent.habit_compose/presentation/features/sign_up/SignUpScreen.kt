package com.baitent.habit_compose.presentation.features.sign_up


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.baitent.habit_compose.presentation.common.views.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.email
import habit_compose.composeapp.generated.resources.emailError
import habit_compose.composeapp.generated.resources.emailPlaceholder
import habit_compose.composeapp.generated.resources.name
import habit_compose.composeapp.generated.resources.nameError
import habit_compose.composeapp.generated.resources.namePlaceholder
import habit_compose.composeapp.generated.resources.password
import habit_compose.composeapp.generated.resources.passwordConfirmation
import habit_compose.composeapp.generated.resources.passwordConfirmationError
import habit_compose.composeapp.generated.resources.passwordError
import habit_compose.composeapp.generated.resources.passwordPlaceholder
import habit_compose.composeapp.generated.resources.signIn
import habit_compose.composeapp.generated.resources.signUp
import kotlinx.coroutines.flow.Flow
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignUpScreen() {

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        AuthLabel(
            title = stringResource(Res.string.signUp),
            onClick = { },
            textButtonTitle = stringResource(Res.string.signIn)
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        TextFieldItem(
            label = stringResource(Res.string.name),
            placeholderId = stringResource(Res.string.namePlaceholder),
            errorMessageId = stringResource(Res.string.nameError),
            isPassword = false,
            onValueChanged = { },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = stringResource(Res.string.email),
            placeholderId = stringResource(Res.string.emailPlaceholder),
            errorMessageId = stringResource(Res.string.emailError),
            isPassword = false,
            onValueChanged = { },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = stringResource(Res.string.password),
            placeholderId = stringResource(Res.string.passwordPlaceholder),
            errorMessageId = stringResource(Res.string.passwordError),
            isPassword = false,
            onValueChanged = { },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = stringResource(Res.string.passwordConfirmation),
            placeholderId = stringResource(Res.string.passwordPlaceholder),
            errorMessageId = stringResource(Res.string.passwordConfirmationError),
            isPassword = false,
            onValueChanged = { },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        CustomButton(
            text = stringResource(Res.string.signUp),
            onClick = {

            }
        )
        CustomTextButton(
            text = stringResource(Res.string.signUp),
            onClick = { },
            icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
            iconColor = LocalColors.current.white
        )
    }
}
