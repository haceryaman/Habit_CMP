import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun LoadingWidget() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        LoadingBar()
    }
}

@Composable
fun LoadingBar(
    circleSize: Dp = 16.dp,
    circleSpacing: Dp = 8.dp,
    amplitude: Dp = 12.dp,
    totalDuration: Int = 1000
) {
    val colors = listOf(
        Color(0xFFFFBF3F),
        Color(0xFF5BC2E7),
        Color(0xFF00B38A),
        Color(0xFF3298BD)
    )
    val delayBetween = totalDuration / colors.size

    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        colors.forEachIndexed { index, color ->
            val offsetY = remember { Animatable(0f) }
            LaunchedEffect(Unit) {
                while (true) {
                    delay((index * delayBetween).toLong())
                    offsetY.animateTo(
                        targetValue = -amplitude.value,
                        animationSpec = tween(
                            durationMillis = totalDuration / 3,
                            easing = FastOutSlowInEasing
                        )
                    )
                    offsetY.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = totalDuration / 3,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    val rest = (totalDuration - 2 * (totalDuration / 3) - index * delayBetween)
                        .coerceAtLeast(0)
                        .toLong()
                    delay(rest)                }
            }

            Box(
                modifier = Modifier
                    .size(circleSize)
                    .offset(y = offsetY.value.dp)
                    .clip(CircleShape)
                    .background(color)
            )

            if (index != colors.lastIndex) {
                Spacer(modifier = Modifier.width(circleSpacing))
            }
        }
    }
}
