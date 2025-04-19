package com.baitent.habit_compose.presentation.common.views.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import habit_compose.composeapp.generated.resources.Res
import habit_compose.composeapp.generated.resources.calendar
import org.jetbrains.compose.resources.painterResource

private val HabitCardGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFFFFB74D),
        Color(0xFFFF8A65)
    )
)

@Composable
fun HabitProgressCard(
    progress: Float,
    completed: Int,
    total: Int,
    modifier: Modifier = Modifier
) {
    val imageSize = 96.dp

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(190.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp, pressedElevation = 3.dp)
    ) {
        Box(
            modifier = Modifier
                .background(HabitCardGradient)
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(24.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = imageSize) // image için boşluk bırak
            ) {
                // a) Circular progress
                Box(
                    modifier = Modifier.size(120.dp),
                    contentAlignment = Alignment.Center
                ) {
                    GradientCircularProgress(
                        progress = progress,
                        size = 115.dp,
                        strokeWidth = 12.dp
                    )
                }

                // b) Metinler
                Column {
                    Text(
                        text = "$completed of $total habits",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = "completed today!",
                        fontSize = 20.sp,
                        color = Color.White
                    )
                }
            }
            Image(
                painter = painterResource(Res.drawable.calendar),
                contentDescription = null,
                modifier = Modifier
                    .size(imageSize)
                    .align(Alignment.BottomEnd)
                    .offset(x = (+30).dp, y = (+28).dp)
                    .alpha(0.9f)
            )
        }
    }
}


@Composable
fun GradientCircularProgress(
    progress: Float,             // 0f..1f
    size: Dp = 115.dp,           // dış kutunun boyu
    strokeWidth: Dp = 12.dp      // arc kalınlığı
) {
    Box(
        Modifier
            .size(size)
    ) {
        val canvasSize = IntSize(250, 250)
        Canvas(modifier = Modifier.matchParentSize()) {
            if (canvasSize.width == 0) return@Canvas

            val diameter = canvasSize.width.coerceAtMost(canvasSize.height).toFloat()
            val radius = (diameter - strokeWidth.toPx()) / 2f
            val centerOffset = Offset(diameter / 2f, diameter / 2f)
            val startAngle = -90f
            val sweep = progress * 360f

            // 1) Track (arka plan a
            drawArc(
                brush = Brush.sweepGradient(
                    0f to Color.White.copy(alpha = 0.3f),
                    0.5f to Color.White.copy(alpha = 0.1f),
                    1f to Color.White.copy(alpha = 0.3f),
                    center = centerOffset
                ),
                startAngle = startAngle + sweep,
                sweepAngle = 360f - sweep,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round),
                topLeft = Offset(
                    (size.toPx() - diameter) / 2f,
                    (size.toPx() - diameter) / 2f
                ),
                size = androidx.compose.ui.geometry.Size(diameter, diameter)
            )

            // 2) Progress arc
            drawArc(
                brush = Brush.sweepGradient(
                    0f to Color.White,
                    1f to Color.White,
                    center = centerOffset
                ),
                startAngle = startAngle,
                sweepAngle = sweep,
                useCenter = false,
                style = Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Round),
                topLeft = Offset(
                    (size.toPx() - diameter) / 2f,
                    (size.toPx() - diameter) / 2f
                ),
                size = androidx.compose.ui.geometry.Size(diameter, diameter)
            )
        }
        Text(
            text = "${(progress * 100).toInt()}%",
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
