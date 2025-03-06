package com.baitent.habit_compose.presentation.features.sign_up


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.baitent.habit_compose.common.AppStrings
import com.baitent.habit_compose.presentation.common.views.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors
import com.baitent.habit_compose.ui.main.MainContract.UiAction
import com.baitent.habit_compose.ui.main.MainContract.UiEffect
import com.baitent.habit_compose.ui.main.MainContract.UiState
import kotlinx.coroutines.flow.Flow

@Composable
fun SignUpScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        AuthLabel(
            title = AppStrings.signUp,
            onClick = { },
            textButtonTitle = AppStrings.signIn
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        TextFieldItem(
            label = AppStrings.name,
            placeholderId = AppStrings.namePlaceholder,
            errorMessageId = AppStrings.nameError,
            isPassword = false,
            onValueChanged = { },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = AppStrings.email,
            placeholderId = AppStrings.emailPlaceholder,
            errorMessageId = AppStrings.emailError,
            isPassword = false,
            onValueChanged = { },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = AppStrings.password,
            placeholderId = AppStrings.passwordPlaceholder,
            errorMessageId = AppStrings.passwordError,
            isPassword = false,
            onValueChanged = { },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = AppStrings.passwordConfirmation,
            placeholderId = AppStrings.passwordPlaceholder,
            errorMessageId = AppStrings.passwordConfirmationError,
            isPassword = false,
            onValueChanged = { },
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        CustomButton(
            text = AppStrings.signUp,
            onClick = { }
        )
        CustomTextButton(
            text = AppStrings.signUp,
            onClick = { },
            icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
            iconColor = LocalColors.current.white
        )

    }
}