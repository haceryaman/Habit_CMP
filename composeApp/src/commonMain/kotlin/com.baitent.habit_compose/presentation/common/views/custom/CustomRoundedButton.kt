import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.common.Dimens
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun CustomButton(
    text: String?,
    onClick: () -> Unit,
    icon: ImageVector? = null,
    modifier: Modifier = Modifier,
    color: Color = LocalColors.current.primary,
    enabled: Boolean = true,
    loading: Boolean=false,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(AppDimensions.buttonHeight)
            .fillMaxWidth(),
        shape = RoundedCornerShape(Dimens.rounded15dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        enabled = enabled
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            icon?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
            if (text != null) {
                Text(
                    text = text,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}