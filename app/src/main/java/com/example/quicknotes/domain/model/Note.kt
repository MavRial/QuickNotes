package com.example.quicknotes.domain.model

data class Note(
    val id: String = "",
    val usedId: String = "",
    val title: String = "",
    val content: String = "",
    val lastModified: Long = System.currentTimeMillis()
)
