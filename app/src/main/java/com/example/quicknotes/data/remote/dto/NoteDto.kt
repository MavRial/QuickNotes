package com.example.quicknotes.data.remote.dto

data class NoteDto(
    val id: String? = null,
    val userId: String? = null,
    val title: String? = null,
    val content: String? = null,
    val lastModified: Long? = null
)
