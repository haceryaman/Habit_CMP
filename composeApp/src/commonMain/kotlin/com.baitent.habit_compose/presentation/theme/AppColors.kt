package com.baitent.habit_compose.presentation.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// AppColor sınıfı, dinamik olarak değiştirilebilen renk özelliklerini temsil eder.
// mutableStateOf ile tanımlandığı için, bir renk değiştiğinde UI otomatik olarak güncellenir.
class AppColors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    surface: Color,
    onPrimary: Color,
    onSecondary: Color,
    customButtonColor: Color,
    white: Color,
    black: Color,
    semiTransparentWhite: Color,
    gray: Color,
    lightGray: Color,
    red: Color,
    darkGray: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    tertiary: Color,
    transparent:Color,

    unfocusedBorderColor: Color,
    focusBorderColor: Color,


    ) {
    // Renk değerlerini dinamik olarak saklayan değişkenler
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var secondaryVariant by mutableStateOf(secondaryVariant)
        private set
    var background by mutableStateOf(background)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var customButtonColor by mutableStateOf(customButtonColor)
        private set
    var white by mutableStateOf(white)
        private set
    var black by mutableStateOf(black)
        private set
    var semiTransparentWhite by mutableStateOf(semiTransparentWhite)
        private set
    var transparent by mutableStateOf(transparent)
        private set
    var gray by mutableStateOf(gray)
        private set
    var lightGray by mutableStateOf(lightGray)
        private set
    var red by mutableStateOf(red)
        private set
    var darkGray by mutableStateOf(darkGray)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var onError by mutableStateOf(onError)
        private set
    var tertiary by mutableStateOf(tertiary)
        private set
    var unfocusedBorderColor by mutableStateOf(unfocusedBorderColor)
        private set
    var focusedBorderColor by mutableStateOf(focusBorderColor)
        private set
}

fun lightColors(
    primary: Color = Color(0xFFF6BD60),
    primaryVariant: Color = Color(0xFFF7EDE2),
    secondary: Color = Color(0xFFF5CAC3),
    secondaryVariant: Color = Color(0xFF84A59D),
    background: Color = Color(0xFFFFFFFF),
    surface: Color = Color(0xFFF7EDE2),
    tertiary: Color = Color(0xFFF28482),
    onPrimary: Color = Color.Black,
    onSecondary: Color = Color.Black,
    customButtonColor: Color = Color(0xFFFFE5E5),
    white: Color = Color(0xFFFFFFFF),
    black: Color = Color(0xFF000000),
    semiTransparentWhite: Color = Color(0xB2FFFFFF),
    gray: Color = Color(0xFF888888),
    lightGray: Color = Color(0xFFCCCCCC),
    red: Color = Color(0xFFFF0000),
    darkGray: Color = Color(0xFF444444),
    onBackground: Color = Color.Black,
    onSurface: Color = Color.Black,
    onError: Color = Color.Red,
    transparent: Color = Color.Transparent,
    unfocusedBorderColor: Color= Color(0xFFEDEDED),
    focusBorderColor: Color= Color(0xFF696464),
): AppColors = AppColors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    background = background,
    surface = surface,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    customButtonColor = customButtonColor,
    white = white,
    black = black,
    semiTransparentWhite = semiTransparentWhite,
    gray = gray,
    lightGray = lightGray,
    red = red,
    darkGray = darkGray,
    onBackground = onBackground,
    onSurface = onSurface,
    onError = onError,
    tertiary = tertiary,
    transparent = transparent,
    unfocusedBorderColor = unfocusedBorderColor,
    focusBorderColor = focusBorderColor,
)

fun darkColors(
    primary: Color = Color(0xFFF6BD60),
    primaryVariant: Color = Color(0xFFF7EDE2),
    secondary: Color = Color(0xFFF5CAC3),
    secondaryVariant: Color = Color(0xFF84A59D),
    background: Color = Color(0xFFF6F6F6),
    surface: Color = Color(0xFFF7EDE2),
    tertiary: Color = Color(0xFFF28482),
    onPrimary: Color = Color.Black,
    onSecondary: Color = Color.Black,
    customButtonColor: Color = Color(0xFFFFE5E5),
    white: Color = Color(0xFFFFFFFF),
    black: Color = Color(0xFF000000),
    semiTransparentWhite: Color = Color(0xB2FFFFFF),
    gray: Color = Color(0xFF888888),
    lightGray: Color = Color(0xFFCCCCCC),
    red: Color = Color(0xFFFF0000),
    darkGray: Color = Color(0xFF444444),
    onBackground: Color = Color.Black,
    onSurface: Color = Color.Black,
    onError: Color = Color.Red,
    transparent: Color = Color.Transparent,
    unfocusedBorderColor: Color= Color(0xFFEDEDED),
    focusBorderColor: Color= Color(0xFF696464),
    ): AppColors = AppColors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    background = background,
    surface = surface,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    customButtonColor = customButtonColor,
    white = white,
    black = black,
    semiTransparentWhite = semiTransparentWhite,
    gray = gray,
    lightGray = lightGray,
    red = red,
    darkGray = darkGray,
    onBackground = onBackground,
    onSurface = onSurface,
    onError = onError,
    tertiary = tertiary,
    transparent = transparent,
    unfocusedBorderColor=unfocusedBorderColor,
    focusBorderColor=focusBorderColor,
)

// Uygulama boyunca kullanılacak olan renk teması için bir CompositionLocal sağlar.
// Bu, renklerin herhangi bir Composable fonksiyonda erişilebilir olmasını sağlar.
val LocalColors = staticCompositionLocalOf { lightColors() }

/*
package com.baitent.habit_compose.presentation.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

// AppColor sınıfı, dinamik olarak değiştirilebilen renk özelliklerini temsil eder.
// mutableStateOf ile tanımlandığı için, bir renk değiştiğinde UI otomatik olarak güncellenir.
class AppColors(
    primary: Color,
    primaryVariant: Color,
    secondary: Color,
    secondaryVariant: Color,
    background: Color,
    surface: Color,
    onPrimary: Color,
    onSecondary: Color,
    customButtonColor: Color,
    white: Color,
    black: Color,
    semiTransparentWhite: Color,
    gray: Color,
    lightGray: Color,
    red: Color,
    darkGray: Color,
    onBackground: Color,
    onSurface: Color,
    onError: Color,
    tertiary: Color,
    transparent: Color,

    unfocusedBorderColor: Color,
    focusBorderColor: Color,


    ) {
    // Renk değerlerini dinamik olarak saklayan değişkenler
    var primary by mutableStateOf(primary)
        private set
    var primaryVariant by mutableStateOf(primaryVariant)
        private set
    var secondary by mutableStateOf(secondary)
        private set
    var secondaryVariant by mutableStateOf(secondaryVariant)
        private set
    var background by mutableStateOf(background)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var onSecondary by mutableStateOf(onSecondary)
        private set
    var customButtonColor by mutableStateOf(customButtonColor)
        private set
    var white by mutableStateOf(white)
        private set
    var black by mutableStateOf(black)
        private set
    var semiTransparentWhite by mutableStateOf(semiTransparentWhite)
        private set
    var transparent by mutableStateOf(transparent)
        private set
    var gray by mutableStateOf(gray)
        private set
    var lightGray by mutableStateOf(lightGray)
        private set
    var red by mutableStateOf(red)
        private set
    var darkGray by mutableStateOf(darkGray)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var onError by mutableStateOf(onError)
        private set
    var tertiary by mutableStateOf(tertiary)
        private set
    var unfocusedBorderColor by mutableStateOf(unfocusedBorderColor)
        private set
    var focusedBorderColor by mutableStateOf(focusBorderColor)
        private set
}

fun lightColors(
    primary: Color = Color(0xFFF6BD60),
    primaryVariant: Color = Color(0xFFF7EDE2),
    secondary: Color = Color(0xFFF5CAC3),
    secondaryVariant: Color = Color(0xFF84A59D),
    background: Color = Color(0xFFFBFBFB),
    surface: Color = Color(0xFFF7EDE2),
    tertiary: Color = Color(0xFFF28482),
    onPrimary: Color = Color.Black,
    onSecondary: Color = Color.Black,
    customButtonColor: Color = Color(0xFFFFE5E5),
    white: Color = Color(0xFFFFFFFF),
    black: Color = Color(0xFF000000),
    semiTransparentWhite: Color = Color(0xB2FFFFFF),
    gray: Color = Color(0xFF888888),
    lightGray: Color = Color(0xFFCCCCCC),
    red: Color = Color(0xFFFF0000),
    darkGray: Color = Color(0xFF444444),
    onBackground: Color = Color.Black,
    onSurface: Color = Color.Black,
    onError: Color = Color.Red,
    transparent: Color = Color.Transparent,
    unfocusedBorderColor: Color = Color(0xFFEDEDED),
    focusBorderColor: Color = Color(0xFF696464),
): ColorScheme = ColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryVariant,
    onPrimaryContainer = Color.Cyan,
    inversePrimary = Color.Cyan,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryVariant,
    onSecondaryContainer = Color.Cyan,
    tertiary = tertiary,
    onTertiary = Color.Cyan,
    tertiaryContainer = Color.Cyan,
    onTertiaryContainer = Color.Cyan,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = Color.Cyan,
    onSurfaceVariant = Color.Cyan,
    surfaceTint = Color.Cyan,
    inverseSurface = Color.Cyan,
    inverseOnSurface = Color.Cyan,
    error = Color.Cyan,
    onError = onError,
    errorContainer = Color.Cyan,
    onErrorContainer = Color.Cyan,
    outline = Color.Cyan,
    outlineVariant = Color.Cyan,
    scrim = Color.Cyan,
    surfaceBright = Color.Cyan,
    surfaceDim =Color.Cyan,
    surfaceContainer = Color.Cyan,
    surfaceContainerHigh = Color.Cyan,
    surfaceContainerHighest = Color.Cyan,
    surfaceContainerLow = Color.Cyan,
    surfaceContainerLowest = Color.Cyan,
)

fun darkColors(
    primary: Color = Color(0xFFF6BD60),
    primaryVariant: Color = Color(0xFFF7EDE2),
    secondary: Color = Color(0xFFF5CAC3),
    secondaryVariant: Color = Color(0xFF84A59D),
    background: Color = Color(0xFFF6F6F6),
    surface: Color = Color(0xFFF7EDE2),
    tertiary: Color = Color(0xFFF28482),
    onPrimary: Color = Color.Black,
    onSecondary: Color = Color.Black,
    customButtonColor: Color = Color(0xFFFFE5E5),
    white: Color = Color(0xFFFFFFFF),
    black: Color = Color(0xFF000000),
    semiTransparentWhite: Color = Color(0xB2FFFFFF),
    gray: Color = Color(0xFF888888),
    lightGray: Color = Color(0xFFCCCCCC),
    red: Color = Color(0xFFFF0000),
    darkGray: Color = Color(0xFF444444),
    onBackground: Color = Color.Black,
    onSurface: Color = Color.Black,
    onError: Color = Color.Red,
    transparent: Color = Color.Transparent,
    unfocusedBorderColor: Color = Color(0xFFEDEDED),
    focusBorderColor: Color = Color(0xFF696464),
): AppColors = AppColors(
    primary = primary,
    primaryVariant = primaryVariant,
    secondary = secondary,
    secondaryVariant = secondaryVariant,
    background = background,
    surface = surface,
    onPrimary = onPrimary,
    onSecondary = onSecondary,
    customButtonColor = customButtonColor,
    white = white,
    black = black,
    semiTransparentWhite = semiTransparentWhite,
    gray = gray,
    lightGray = lightGray,
    red = red,
    darkGray = darkGray,
    onBackground = onBackground,
    onSurface = onSurface,
    onError = onError,
    tertiary = tertiary,
    transparent = transparent,
    unfocusedBorderColor = unfocusedBorderColor,
    focusBorderColor = focusBorderColor,
)

// Uygulama boyunca kullanılacak olan renk teması için bir CompositionLocal sağlar.
// Bu, renklerin herhangi bir Composable fonksiyonda erişilebilir olmasını sağlar.
val LocalColors = staticCompositionLocalOf { lightColors() }

 */