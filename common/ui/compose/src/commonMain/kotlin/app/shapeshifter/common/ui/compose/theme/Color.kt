package app.shapeshifter.common.ui.compose.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val VampireBlack = Color(0xFF070707)
val Coal = Color(0xFF282828)
val Color.Companion.Procelain
    get() = Color(0xFFF2F5F6)

val ShapeShifterLightColorScheme = lightColorScheme(
    primary = VampireBlack,
    secondary = VampireBlack,
    onPrimary = Color.White,
    onSecondary = Color.White,
    surface = Color.White,
    onSurface = VampireBlack,
    background = Color.White,
)

val ShapeShifterDarkColorScheme = darkColorScheme(
    primary = Coal,
    secondary = Coal,
    onPrimary = Color.White,
    onSecondary = Color.White,
    surface = Color.Black,
    background = Color.Black,
)
