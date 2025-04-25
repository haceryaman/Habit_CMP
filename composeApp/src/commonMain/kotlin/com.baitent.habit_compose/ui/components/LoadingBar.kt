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
    // Topların renkleri JSON'daki dolgu renklerinden alındı
    val colors = listOf(
        Color(0xFFFFBF3F), // sarı-turuncu :contentReference[oaicite:2]{index=2}&#8203;:contentReference[oaicite:3]{index=3}
        Color(0xFF5BC2E7), // açık mavi :contentReference[oaicite:4]{index=4}&#8203;:contentReference[oaicite:5]{index=5}
        Color(0xFF00B38A), // yeşil :contentReference[oaicite:6]{index=6}&#8203;:contentReference[oaicite:7]{index=7}
        Color(0xFF3298BD)  // koyu mavi :contentReference[oaicite:8]{index=8}&#8203;:contentReference[oaicite:9]{index=9}
    )
    val delayBetween = totalDuration / colors.size

    Row(
        modifier = Modifier.wrapContentWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        colors.forEachIndexed { index, color ->
            // Her top için ayrı animasyonlu offset
            val offsetY = remember { Animatable(0f) }
            LaunchedEffect(Unit) {
                // Sürekli dönen bir döngü
                while (true) {
                    // Başlangıç gecikmesi
                    delay((index * delayBetween).toLong())
                    // Yukarı zıplama
                    offsetY.animateTo(
                        targetValue = -amplitude.value,
                        animationSpec = tween(
                            durationMillis = totalDuration / 3,
                            easing = FastOutSlowInEasing
                        )
                    )
                    // Geri inme
                    offsetY.animateTo(
                        targetValue = 0f,
                        animationSpec = tween(
                            durationMillis = totalDuration / 3,
                            easing = LinearOutSlowInEasing
                        )
                    )
                    // Kalan sürede bekle (dinlenme fazı)
                    // Dinlenme fazı: Int hesaplamayı önce maksimum 0’a çektik, sonra Long’a çevirdik
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
