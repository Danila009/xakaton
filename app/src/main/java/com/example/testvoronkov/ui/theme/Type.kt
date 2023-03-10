package com.example.testvoronkov.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testvoronkov.R

val font = FontFamily(
    Font(R.font.montserrat_light),
)
val body = FontFamily(
    Font(R.font.montserrat_bold, FontWeight.Bold),
)

val Typography = Typography(

    body1 = TextStyle(
        fontFamily = font,
        fontWeight = FontWeight.Normal
    ),
    body2 = TextStyle(
        fontFamily = body,
        fontWeight = FontWeight.Bold
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)
