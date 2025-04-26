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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.baitent.habit_compose.common.Dimens
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun CustomButton(
    text: String? = null,
    onClick: () -> Unit,
    iconVector: ImageVector? = null,
    iconPainter: Painter? = null,
    iconContent: (@Composable () -> Unit)? = null,
    modifier: Modifier = Modifier,
    color: Color = LocalColors.current.primary,
    enabled: Boolean = true,
    loading: Boolean = false,
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .height(AppDimensions.buttonHeight)
            .fillMaxWidth(),
        shape = RoundedCornerShape(Dimens.rounded15dp),
        colors = ButtonDefaults.buttonColors(containerColor = color),
        enabled = enabled && !loading
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            iconVector?.let {
                Icon(
                    imageVector = it,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(8.dp))
            }
            iconPainter?.let {
                Icon(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(Modifier.width(8.dp))
            }
            iconContent?.let { content ->
                content()
                Spacer(Modifier.width(8.dp))
            }
            text?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
                )
            }
        }
    }
}
