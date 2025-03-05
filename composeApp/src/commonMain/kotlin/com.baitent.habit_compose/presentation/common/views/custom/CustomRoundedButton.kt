package com.baitent.habit_compose.presentation.common.views.custom

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.baitent.habit_compose.presentation.features.common.constants.Dimens
import com.baitent.habit_compose.presentation.theme.AppDimensions
import com.baitent.habit_compose.presentation.theme.LocalColors

@Composable
fun CustomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = LocalColors.current.primary,
    gradientColors:List<Color>? = null,
    enabled: Boolean = true
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
     Text(text = text, fontSize = Dimens.textSize16sp, fontWeight = FontWeight.Bold)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    CustomButton(text = "Button", onClick = {  })
}
