package com.example.harrypotterapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.example.harrypotterapp.R
import com.example.harrypotterapp.R.font

// Set of Material typography styles to start with
val rosarivo = FontFamily(
    Font(R.font.rosarivo_italic, weight = FontWeight.Normal, style = FontStyle.Italic),
    Font(R.font.rosarivo_regular, weight = FontWeight.Normal, style = FontStyle.Normal)
)

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = rosarivo,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp
    ),
    bodySmall = TextStyle(
        fontFamily = rosarivo,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp
    ),
    labelSmall = TextStyle(
        fontFamily = rosarivo,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

/*val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)*/
