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
import com.baitent.habit_compose.common.AppStrings
import com.baitent.habit_compose.presentation.common.views.items.TextFieldItem
import com.baitent.habit_compose.presentation.common.views.items.AuthLabel
import com.baitent.habit_compose.presentation.common.views.custom.CustomButton
import com.baitent.habit_compose.presentation.common.views.custom.CustomTextButton
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors
import com.baitent.habit_compose.ui.main.MainContract.UiAction
import com.baitent.habit_compose.ui.main.MainContract.UiEffect
import com.baitent.habit_compose.ui.main.MainContract.UiState
import kotlinx.coroutines.flow.Flow

@Composable
fun SignInScreen(
    uiState: UiState,
    uiEffect: Flow<UiEffect>,
    onAction: (UiAction) -> Unit,
    onSignInClick: () -> Unit = {},
){
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        AuthLabel(
            title = AppStrings.signIn,
            onClick = onSignInClick,
            textButtonTitle= AppStrings.signUp
        )
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        TextFieldItem(
            label = AppStrings.email,
            placeholderId = AppStrings.emailPlaceholder,
            errorMessageId = AppStrings.emailError,
            isPassword = false,
            onValueChanged = {},
            value = ""
        )
        Spacer(modifier = Modifier.height(AppDimensions.mediumSpace))
        TextFieldItem(
            label = AppStrings.password,
            placeholderId = AppStrings.passwordPlaceholder,
            errorMessageId = AppStrings.passwordError,
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
                    text = AppStrings.rememberMe,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }

            CustomTextButton(
                text = AppStrings.forgotPassword,
                onClick = {},
                icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
                iconColor = LocalColors.current.white
            )
        }
        Spacer(modifier = Modifier.height(AppDimensions.xxxLargeSpace))
        CustomButton(
            text = AppStrings.signIn,
            onClick = {  }
        )
        CustomTextButton(
            text = AppStrings.orLoginWith,
            onClick = {},
            icon = Icons.AutoMirrored.Default.KeyboardArrowRight,
            iconColor = LocalColors.current.white
        )

    }
}
