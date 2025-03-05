import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes labelId: Int,
    @StringRes placeholderId: Int? = null,
    isPassword: Boolean = false,
    isError: Boolean = false,
    @StringRes errorMessageId: Int? = null,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        OutlinedTextField(
            shape = RoundedCornerShape(AppDimensions.textFieldRadius) ,
            singleLine = true,
            value = value,
            onValueChange = onValueChange,
            //  label = null,
            placeholder = {
                placeholderId?.let {
                    Text(stringResource(id = it), style = MaterialTheme.typography.bodySmall)
                }
            },
            //  visualTransformation = if (isPassword) VisualTransformation.Password else VisualTransformation.None,
            isError = isError,
            modifier = Modifier.height(AppDimensions.textFieldHeight).fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = LocalColors.current.white,
                unfocusedContainerColor = LocalColors.current.white,
                focusedBorderColor = LocalColors.current.unfocusedBorderColor,
            )
        )

        if (isError && errorMessageId != null) {
            Text(
                text = stringResource(id = errorMessageId),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                //modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}

@Preview (showBackground = true)
@Composable
fun CustomTextFieldPreview() {
    var value by remember { mutableStateOf("hacer yaman") }
    CustomTextField(
        value = value,
        onValueChange = { value = it },
        labelId = android.R.string.copy,
        placeholderId = android.R.string.copy,
        isPassword = true,
        isError = true,
        errorMessageId = android.R.string.copy
    )
}
