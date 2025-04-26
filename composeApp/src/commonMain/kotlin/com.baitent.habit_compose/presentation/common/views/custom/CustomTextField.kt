import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.material3.OutlinedTextFieldDefaults.colors
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String? = null,
    isPassword: Boolean = false,
    isError: Boolean = false,
    errorMessage: String? = null,
    modifier: Modifier = Modifier
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(modifier = modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            singleLine = true,
            shape = RoundedCornerShape(AppDimensions.textFieldRadius),
            modifier = Modifier.height(AppDimensions.textFieldHeight).fillMaxWidth(),

            placeholder = placeholder?.let {
                { Text(it, style = MaterialTheme.typography.bodySmall.copy(
                    color = LocalColors.current.lightGray
                )) }
            },

            visualTransformation = when {
                isPassword && !passwordVisible -> PasswordVisualTransformation()
                else -> VisualTransformation.None
            },

            trailingIcon = if (isPassword) {
                val image = if (passwordVisible) Icons.Default.Visibility
                else Icons.Default.VisibilityOff
                val desc = if (passwordVisible) null
                else null

                {
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, contentDescription = desc)
                    }
                }
            } else null,

            keyboardOptions = KeyboardOptions(
                keyboardType = if (isPassword) KeyboardType.Password else KeyboardType.Text
            ),

            isError = isError,
            colors = colors(
                focusedContainerColor = LocalColors.current.white,
                unfocusedContainerColor = LocalColors.current.white,
                focusedBorderColor = LocalColors.current.unfocusedBorderColor,
            ))

        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(start = 8.dp, top = 4.dp)
            )
        }
    }
}
