package com.example.quicknotes.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.example.quicknotes.ui.theme.BlueDark
import com.example.quicknotes.ui.theme.WhiteText

@Composable
fun FloatingAddButton(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = BlueDark,
        contentColor = WhiteText
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Add Note")
    }
}