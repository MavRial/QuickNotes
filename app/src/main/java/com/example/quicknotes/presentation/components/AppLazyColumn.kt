package com.example.quicknotes.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.Dp

@Composable
fun <T> AppLazyColumn(
    itemsList: List<T>,
    modifier: Modifier = Modifier,
    itemSpacing: Dp = 8.dp,
    content: @Composable (T) -> Unit
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(itemSpacing)
    ) {
        items(itemsList) { item ->
            content(item)
        }
    }
}