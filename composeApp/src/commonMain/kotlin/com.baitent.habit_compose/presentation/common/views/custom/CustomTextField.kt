import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Column(modifier = modifier) {
        OutlinedTextField(
            shape = RoundedCornerShape(AppDimensions.textFieldRadius) ,
            singleLine = true,
            value = value,
            onValueChange = onValueChange,
            //  label = null,
            placeholder = {
                placeholder?.let {
                    Text(placeholder, style = MaterialTheme.typography.bodySmall)
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

        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                //modifier = Modifier.padding(start = 16.dp, top = 4.dp)
            )
        }
    }
}
