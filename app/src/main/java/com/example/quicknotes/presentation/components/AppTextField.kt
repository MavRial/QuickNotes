package com.example.quicknotes.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.quicknotes.ui.theme.Accent
import com.example.quicknotes.ui.theme.BlueDark
import com.example.quicknotes.ui.theme.SoftYellow

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String = "",
    @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
    backgroundColor: Color = SoftYellow,
    textColor: Color = BlueDark,
    shape: RoundedCornerShape = RoundedCornerShape(12.dp)
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier = modifier.fillMaxWidth(),
        shape = shape,
        colors = TextFieldDefaults.colors(
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            disabledTextColor = textColor.copy(alpha = 0.5f),
            cursorColor = Accent,
            focusedContainerColor = backgroundColor,
            unfocusedContainerColor = backgroundColor,
            disabledContainerColor = backgroundColor.copy(alpha = 0.5f),
            focusedIndicatorColor = BlueDark,
            unfocusedIndicatorColor = BlueDark.copy(alpha = 0.5f),
            disabledIndicatorColor = BlueDark.copy(alpha = 0.2f),
            focusedLabelColor = BlueDark,
            unfocusedLabelColor = BlueDark.copy(alpha = 0.7f),
            disabledLabelColor = BlueDark.copy(alpha = 0.5f)
        )
    )
}