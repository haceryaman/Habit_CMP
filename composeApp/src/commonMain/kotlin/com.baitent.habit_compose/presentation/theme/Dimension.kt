package com.baitent.habit_compose.presentation.theme

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

//object:
//Singleton Pattern: object, singleton bir nesne oluşturur.
// Yani, object ile tanımlanan sınıf sadece bir kez yaratılır ve tüm program boyunca tek bir örneği vardır.

object AppDimensions {

    val smallPadding: Dp = 8.dp
    val mediumPadding: Dp = 16.dp
    val largePadding: Dp = 24.dp
    val xLargePadding: Dp = 32.dp
    val xxLargePadding: Dp = 48.dp

    val buttonHeight: Dp = 48.dp
    val buttonWidth: Dp = 200.dp

    val smallSpace: Dp = 4.dp
    val mediumSpace: Dp = 8.dp
    val largeSpace: Dp = 16.dp
    val xLargeSpace: Dp = 24.dp
    val xxLargeSpace: Dp = 32.dp
    val xxxLargeSpace: Dp = 48.dp


    val titleTextSize: Dp = 24.dp
    val bodyTextSize: Dp = 16.dp

    val cornerRadius: Dp = 12.dp

    val textFieldRadius: Dp = 8.dp
    val textFieldHeight:Dp = 48.dp      //button height ile aynı olmalı
}
