package com.example.myapplication.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = darkColorScheme(
    primary = Color(0xff6750A4),
    onPrimary = Color(0xffFFFFFF),
    primaryContainer = Color(0xffEADDFF),
    onPrimaryContainer = Color(0xff21005D),
    secondary = Color(0xff625B71),
    onSecondary = Color(0xffFFFFFF),
    secondaryContainer = Color(0xffE8DEF8),
    onSecondaryContainer = Color(0xff1D192B),
    tertiary = Color(0xff7D5260),
    onTertiary = Color(0xffFFFFFF),
    tertiaryContainer = Color(0xffFFD8E4),
    onTertiaryContainer = Color(0xff31111D),
    error = Color(0xffB3261E),
    onError = Color(0xffFFFFFF),
    errorContainer = Color(0xffF9DEDC),
    onErrorContainer = Color(0xff410E0B),
    background = Color(0xffFFFFFF),
    onBackground = Color(0xff1C1B1F),
    surface = Color(0xfffffbfe),
    onSurface = Color(0xff1C1B1F),
    surfaceVariant = Color(0xffE7E0EC),
    onSurfaceVariant = Color(0xff49454F),
    outline = Color(0xff79747E),
    outlineVariant = Color(0xffCAC4D0),
)

private val DarkColorScheme = lightColorScheme(
    primary = Color(0xffD0BCFF),
    onPrimary = Color(0xff381E72),
    primaryContainer = Color(0xff4F378B),
    onPrimaryContainer = Color(0xffEADDFF),
    secondary = Color(0xffCCC2DC),
    onSecondary = Color(0xff332D41),
    secondaryContainer = Color(0xff4A4458),
    onSecondaryContainer = Color(0xffE8DEF8),
    tertiary = Color(0xffEFB8C8),
    onTertiary = Color(0xff492532),
    tertiaryContainer = Color(0xff633B48),
    onTertiaryContainer = Color(0xffFFD8E4),
    error = Color(0xffF2B8B5),
    onError = Color(0xff601410),
    errorContainer = Color(0xff8C1D18),
    onErrorContainer = Color(0xffF9DEDC),
    background = Color(0xff1C1B1F),
    onBackground = Color(0xffE6E1E5),
    surface = Color(0xff1C1B1F),
    onSurface = Color(0xffE6E1E5),
    surfaceVariant = Color(0xff49454F),
    onSurfaceVariant = Color(0xffCAC4D0),
    outline = Color(0xff938F99),
    outlineVariant = Color(0xff49454F),
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}