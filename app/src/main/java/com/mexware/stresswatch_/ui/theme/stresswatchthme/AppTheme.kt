package com.mexware.stresswatch_.ui.theme.stresswatchthme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.ui.graphics.Color

val darkMode = darkColorScheme(
    background = backgroundDark,
    inverseOnSurface = TextColorInfoDark,
    onTertiaryContainer = TextColorClickDark,
    surfaceContainerLowest = ButtonDark,
    surfaceContainerLow = PlaceHolderButtonDark,
    primaryContainer = PlaceHolderTextFieldDark,
    inversePrimary = TextFieldCustomDark


    )

val lightMode = lightColorScheme(
    background = backgroundLight,
    inverseOnSurface = TextColorInfoLight,
    onTertiaryContainer = TextColorClickLight,
    surfaceContainerLowest = ButtonLight,
    surfaceContainerLow = PlaceHolderButtonLight,
    primaryContainer = PlaceHolderTextFieldLight,
    inversePrimary = TextFieldCustomLight


)

@Composable
fun AppTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit



){

    val colors = if (isDarkMode) darkMode else lightMode


    MaterialTheme(
        colorScheme = colors,
        content = content
    )
}