package com.example.quicknotes.presentation.components

import android.annotation.SuppressLint


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalConfiguration
import com.example.quicknotes.ui.theme.BlueDark

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun AppText(
    text: String,
    modifier: Modifier = Modifier,
    fontSize: Float? = null,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = BlueDark,
    maxLines: Int = Int.MAX_VALUE,
    style: TextStyle? = null
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    val scaleFactor = screenWidth / 360f
    val responsiveSize = (fontSize ?: 16f) * scaleFactor

    Text(
        text = text,
        modifier = modifier,
        fontSize = responsiveSize.sp,
        fontWeight = fontWeight,
        color = color,
        maxLines = maxLines,
        style = style ?: TextStyle.Default
    )
}