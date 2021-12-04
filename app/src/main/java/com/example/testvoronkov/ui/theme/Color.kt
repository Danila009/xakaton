package com.example.testvoronkov.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


val gol0 = Color(0xFDFAFCFF)
val gol1 = Color(0xFD007BFF)
val gol = Color(0xFD73EAFF)
val gol_1 = Color(0xFD007BFF)
val gol_2 = Color(0xFD005D6D)


val white = Color(0xFFFFFFFF)
val black = Color(0xFF292626)

val biruzoviy = Color(0xFF00ACAB)

val blue = Color(0xFF0518A1)

val yellow = Color(0xFFEDED00)



val baseLightPalette= JetHabbitColors(
    //primaryBackground = Color(0xFD007BFF),
    primaryText = Color(0xFF000000),
    Brush.verticalGradient(listOf(
        white,
        biruzoviy
    )),

    primaryBackground = gol0,

    secondaryBackground = Color(0xFDFFFFFF),
    //secondaryText = Color(0xFD005D6D),
    tintColor = Color.Magenta
)

val baseDarkPalette = JetHabbitColors(
    //primaryBackground = Color(0xFD007BFF),
    primaryText = Color(0xFDFFFFFF),
    Brush.verticalGradient(listOf(
        black,
        biruzoviy
    )),
    primaryBackground =Color(0xFF141414),
    secondaryBackground = Color(0xFD000000),
    //secondaryText = Color(0xFD005D6D),
    tintColor = Color.Magenta
)

val TextPrimaryLightPalette = baseLightPalette.copy(
    gradient = Brush.verticalGradient(listOf(
        white,
        biruzoviy
    )),
)

val TextPrimaryDarkPalette = baseDarkPalette.copy(
   gradient = Brush.verticalGradient(listOf(
       black,
       biruzoviy
   )),
)

val GradientLightPalette = baseLightPalette.copy(
    primaryText = Color(0xFF000000)
)

val GradientDarkPalette = baseDarkPalette.copy(
    primaryText = Color(0xFFFFFFFF)
)

val BackgroundLightPalette = baseLightPalette.copy(
    tintColor = gol0
)

val BackgroundDarkPalette = baseDarkPalette.copy(
    primaryBackground =Color(0xFF141414),
)

val secondaryBackgroundLightPalette = baseLightPalette.copy(
    secondaryBackground =Color(0xFFFFFFFF),
)

val secondaryBackgroundDarkPalette = baseDarkPalette.copy(
    secondaryBackground =Color(0xFF141414),
)



val purpleLightPalette = baseLightPalette.copy(
    tintColor = Color(0xFFA900FF)
)

val purpleDarkPalette = baseDarkPalette.copy(
    tintColor = Color(0xFF28003D)
)



