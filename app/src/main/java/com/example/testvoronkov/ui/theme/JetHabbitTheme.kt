package com.example.testvoronkov.ui.theme

import androidx.compose.ui.graphics.Color
import android.graphics.drawable.shapes.Shape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.Dp
import java.time.format.TextStyle

data class JetHabbitColors (
    val primaryText:Color,
    val gradient:Brush,
    val primaryBackground:Color,
    //val secondaryText:Color,
    val secondaryBackground:Color,
    val tintColor:Color
    )

data class JetHabbitTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle
)

data class JetHabbitShape(
    val padding: Dp,
    val cornerStyle: Shape
)

data class JetHabbitImage(
    val password:Int
)

object JetHabbitTheme{
    val colors: JetHabbitColors
        @Composable
        get() = LocalJetHabbitColors.current

    val typography: JetHabbitTypography
        @Composable
        get() = LocalJetHabbitTypography.current

    val shapes: JetHabbitShape
        @Composable
        get() = LocalJetHabbitShape.current


    val images: JetHabbitImage
        @Composable
        get() = LocalJetHabbitImage.current
}
enum class JetHabbitStyle{
    TextPrimary,Purple,Gradient,Background,SecondaryBackground
}
enum class JetHabbitSize{
    Small, Medium, Big
}
enum class JetHabbitCorners{
    Flat, Rounded
}


val LocalJetHabbitColors = staticCompositionLocalOf<JetHabbitColors> {
    error("No colors provided")
}

val LocalJetHabbitShape = staticCompositionLocalOf<JetHabbitShape> {
    error("No colors provided")
}

val LocalJetHabbitTypography = staticCompositionLocalOf<JetHabbitTypography> {
    error("No colors provided")
}

val LocalJetHabbitImage = staticCompositionLocalOf<JetHabbitImage> {
    error("No colors provided")
}