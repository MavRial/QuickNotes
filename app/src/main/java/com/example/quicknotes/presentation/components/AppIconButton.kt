package com.example.quicknotes.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quicknotes.ui.theme.BlueDark

@Composable
fun AppIconButton(
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    backgroundColor: Color = BlueDark,
    size: Float = 48f
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(size.dp)
            .background(backgroundColor, CircleShape)
    ) {
        icon()
    }
}